package com.example.movieapp.data.repository
import com.example.movieapp.data.api.MovieDTO
import com.example.movieapp.data.datasource.MovieDatasource
import com.example.movieapp.data.model.MovieResult


class MovieRepositoryImpl(val datasource: MovieDatasource): MovieRepository {

    override suspend fun getMovies(): MovieResult<List<MovieDTO>> {
        return datasource.getMovies()
    }

    override suspend fun getMovieDetail(): MovieDTO {
        TODO("Not yet implemented")
    }

}

