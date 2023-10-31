package com.example.domain.repository

import com.example.domain.model.Movie
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
}