package com.example.movieapp.data.repository

import com.example.movieapp.data.datasource.MovieDatasource
import com.example.movieapp.data.model.ApiResponse
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.toDomain
import com.example.movieapp.data.model.toDomain
import com.example.movieapp.domain.entities.Movie
import com.example.movieapp.domain.entities.NotDataFound
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val datasource: MovieDatasource) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return when (val response = datasource.getMovies()) {
            is ApiResponse.ApiEmptyResponse -> throw NotImplementedError("Implement a strategy when the response is empty")
            is ApiResponse.ApiError -> throw NotImplementedError("Implemented estrategy when the api rest throw a error")
            is ApiResponse.ApiSuccessResponse -> {
                response.body.results.map { it.toDomain() }
            }
        }
    }

    override suspend fun getMovieDetail(id: String): Movie {
        return when (val response = datasource.getMovieDetail(id)) {
            is ApiResponse.ApiEmptyResponse -> throw NotImplementedError("Implement a strategy when the response is empty")
            is ApiResponse.ApiError -> throw NotImplementedError("Implemented estrategy when the api rest throw a error")
            is ApiResponse.ApiSuccessResponse -> response.body.toDomain()
        }
    }

}
