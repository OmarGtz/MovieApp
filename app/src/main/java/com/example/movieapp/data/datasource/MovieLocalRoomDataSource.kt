package com.example.movieapp.data.datasource

import com.example.movieapp.data.database.MovieDao
import com.example.movieapp.data.database.MovieEntity
import javax.inject.Inject

class MovieLocalRoomDataSource @Inject constructor(val movieDao: MovieDao) : MovieLocalDataSource {

    override suspend fun getAllMovies(): List<MovieEntity> {
        return movieDao.getAllMovies()
    }

    override suspend fun getMovieById(id: String): MovieEntity {
        return movieDao.getMovieById(id)
    }

    override suspend fun insertAllMovies(movies: List<MovieEntity>) {
        movieDao.insertMovies(movies)
    }

    override suspend fun deleteAllMovies(movies: List<MovieEntity>) {
        movieDao.deleteMovies(movies)
    }

}