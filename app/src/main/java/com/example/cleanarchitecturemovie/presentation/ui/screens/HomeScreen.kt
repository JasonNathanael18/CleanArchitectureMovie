package com.example.cleanarchitecturemovie.presentation.ui.screens


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cleanarchitecturemovie.presentation.viewmodel.MoviesUiState
import com.example.cleanarchitecturemovie.presentation.viewmodel.MoviesViewModel

const val TAG = "HomeScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    movieViewModel: MoviesViewModel = hiltViewModel()
) {

    val uiState by movieViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movie List") }
            )
        }
    ) {
        val modifier = Modifier.padding(it)
        FullScreenLoading(
            isLoading = uiState.isLoading,
            loadingContent = { },
            content = {
                when (uiState) {
                    is MoviesUiState.HasRepoList -> {
                        LazyColumn {
                            items(items = (uiState as MoviesUiState.HasRepoList).repoList) { repoItem ->
                                //hasRepoList(repoItem = repoItem,modifier = modifier)
                                Text(
                                    text = repoItem.title,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }

                    is MoviesUiState.RepoListEmpty -> {
                        if (uiState.error.isNotEmpty()) {
//                            NetworkErrorMessage(
//                                message = uiState.error,
//                                onClickRefresh = onRefreshRepoList
//                            )
                        } else {
                            Text(text = "You have no repo list right now")
                        }
                    }
                }
            }
        )


    }
}

@Composable
private fun FullScreenLoading(
    isLoading: Boolean,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    if (isLoading) loadingContent()
    else content()
}