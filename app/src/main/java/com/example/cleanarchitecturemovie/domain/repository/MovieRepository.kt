package com.example.cleanarchitecturemovie.domain.repository

import com.example.cleanarchitecturemovie.data.source.remote.Resource
import com.example.cleanarchitecturemovie.domain.model.Movie
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
}