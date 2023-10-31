package com.example.cleanarchitecturemovie.presentation.viewmodel

import com.example.domain.model.Movie

data class MovieUiState(
    val moviesList: List<Movie> = emptyList(),
    val isLoading: Boolean = false
)