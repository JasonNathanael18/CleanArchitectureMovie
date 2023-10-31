package com.example.cleanarchitecturemovie.domain.usecase

import com.example.cleanarchitecturemovie.data.source.remote.Resource
import com.example.cleanarchitecturemovie.domain.model.Movie
import com.example.cleanarchitecturemovie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetPopularMovies(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> {
        return movieRepository.getPopularMovies()
    }
}