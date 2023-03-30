package com.example.movieapp.data.repository

import com.example.movieapp.data.datasource.MovieDatasource
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.toDomain
import com.example.movieapp.data.model.toDomain
import com.example.movieapp.domain.entities.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val datasource: MovieDatasource) : MovieRepository {

    override suspend fun getMovies(): MovieResult<List<Movie>> {
        return when (val result = datasource.getMovies()) {
            is MovieResult.Error -> MovieResult.Error(result.error)
            is MovieResult.Success -> MovieResult.Success(result.data.map { it.toDomain() })
        }
    }

    override suspend fun getMovieDetail(id: String): MovieResult<Movie> {
        return when (val result = datasource.getMovieDetail(id)) {
            is MovieResult.Error -> MovieResult.Error(result.error)
            is MovieResult.Success -> MovieResult.Success(result.data.toDomain())
        }
    }

}
