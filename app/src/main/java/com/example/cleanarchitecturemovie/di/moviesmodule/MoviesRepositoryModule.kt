package com.example.cleanarchitecturemovie.di.moviesmodule

import com.example.cleanarchitecturemovie.data.repository.MovieRepositoryImpl
import com.example.cleanarchitecturemovie.data.source.local.roomdb.dao.MovieDao
import com.example.cleanarchitecturemovie.data.source.local.roomdb.dao.PopularMoviesDao
import com.example.cleanarchitecturemovie.data.source.remote.MovieApiService
import com.example.cleanarchitecturemovie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesRepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepositoryImpl(
        movieApiService: MovieApiService,
        popularMoviesDao: PopularMoviesDao,
        movieDao: MovieDao
    ): MovieRepository = MovieRepositoryImpl(movieApiService, popularMoviesDao, movieDao)

}