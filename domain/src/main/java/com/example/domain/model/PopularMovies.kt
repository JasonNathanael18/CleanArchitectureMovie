package com.example.domain.model

data class PopularMovies(
    var page: Int,
    var results: List<Movie>
)
