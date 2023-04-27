package com.example.movieapp.data.repository

import android.util.Log
import com.example.movieapp.data.database.toDomain
import com.example.movieapp.data.datasource.MovieDatasource
import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.model.ApiResponse
import com.example.movieapp.data.model.toEntity
import com.example.movieapp.domain.entities.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val datasource: MovieDatasource,val localDataSource: MovieLocalDataSource) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        syncMovies()
        return localDataSource.getAllMovies().map { it.toDomain() }
    }

    override suspend fun getMovieDetail(id: String): Movie {
        return localDataSource.getMovieById(id).toDomain()
    }

    private suspend fun syncMovies() {
        try {
        when (val response = datasource.getMovies()) {
            is ApiResponse.ApiSuccessResponse -> {
                val moviesNetwork =  response.body.results.map { it.toEntity() }
                localDataSource.insertAllMovies(moviesNetwork)
            } else -> {
                Log.i("Network error", "Don't save data")
            }
        }
        } catch (e: Exception) {
            Log.e("Unknown error", "Don't save data")
        }
    }


}
