package com.example.data.source.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.source.local.roomdb.entity.PopularMoviesEntity

@Dao
interface PopularMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movies: PopularMoviesEntity)

    @Query("SELECT * FROM ${PopularMoviesEntity.TABLE_NAME}")
    suspend fun getMovieList(): List<PopularMoviesEntity>

    @Query("DELETE FROM ${PopularMoviesEntity.TABLE_NAME}")
    suspend fun deleteAll()
}