package com.example.domain.model

import com.example.domain.model.Movie

data class PopularMovies(
    var page: Int,
    var results: List<Movie>
)
