package com.example.featuremovielist.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Movie
import com.example.domain.usecase.GetPopularMovies
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getPopularMovies: GetPopularMovies
) : ViewModel() {

    private val viewModelState = MutableStateFlow(MoviesViewModelState(isLoading = true))

    val uiState = viewModelState
        .map(MoviesViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun getMovies() {
        viewModelScope.launch {
            getPopularMovies().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        viewModelState.update {
                            it.copy(error = "", isLoading = true)
                        }
                    }
                    is Resource.Success -> {
                        result.data?.let { list ->
                            viewModelState.update {
                                it.copy(repoList = list, isLoading = false)
                            }
                        }
                    }
                    is Resource.Error -> {
                        viewModelState.update {
                            it.copy(
                                error = result.message ?: "",
                                repoList = listOf(),
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}

private data class MoviesViewModelState(
    val isLoading: Boolean = false,
    val error: String = "",
    val repoList: List<Movie> = listOf(),
    val isPreviousPageLoaded: Boolean = false
) {
    fun toUiState(): MoviesUiState =
        if (repoList.isEmpty()) MoviesUiState.RepoListEmpty(
            isLoading = isLoading,
            error = error,
            isPreviousPageLoaded = isPreviousPageLoaded
        )
        else MoviesUiState.HasRepoList(isLoading = isLoading, error = error, repoList = repoList)
}

sealed interface MoviesUiState {
    val isLoading: Boolean
    val error: String

    data class HasRepoList(
        val repoList: List<Movie>,
        override val isLoading: Boolean,
        override val error: String
    ) : MoviesUiState

    data class RepoListEmpty(
        override val isLoading: Boolean,
        override val error: String,
        val isPreviousPageLoaded: Boolean
    ) : MoviesUiState
}