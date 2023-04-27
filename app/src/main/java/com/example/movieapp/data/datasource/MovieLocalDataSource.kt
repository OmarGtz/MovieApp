package com.example.movieapp.data.datasource

import com.example.movieapp.data.database.MovieEntity
import kotlinx.coroutines.flow.Flow


interface MovieLocalDataSource {

    suspend fun getAllMovies(): List<MovieEntity>

    suspend fun getMovieById(id: String): MovieEntity

    suspend fun insertAllMovies(movies: List<MovieEntity>)

    suspend fun deleteAllMovies(movies: List<MovieEntity>)

}