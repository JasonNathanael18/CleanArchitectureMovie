package com.example.cleanarchitecturemovie.data.source.remote

import com.example.cleanarchitecturemovie.data.source.remote.dto.PopularMoviesDto
import retrofit2.http.GET

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesDto

    companion object {
        const val BASE_URL: String = "https://api.themoviedb.org/3/"
    }
}