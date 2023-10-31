package com.example.data.module

import com.example.data.repository.MovieRepositoryImpl
import com.example.data.source.local.roomdb.dao.MovieDao
import com.example.data.source.local.roomdb.dao.PopularMoviesDao
import com.example.data.source.remote.MovieApiService
import com.example.domain.repository.MovieRepository
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