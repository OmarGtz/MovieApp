package com.example.movieapp.data.repository
import com.example.movieapp.data.model.MovieDTO
import com.example.movieapp.data.datasource.MovieDatasource
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO

class MovieRepositoryImpl(val datasource: MovieDatasource): MovieRepository {

    override suspend fun getMovies(): MovieResult<List<MovieDTO>> {
        return datasource.getMovies()
    }

    override suspend fun getMovieDetail(id: String): MovieResult<MovieDetailDTO> {
        return datasource.getMovieDetail(id)
    }
}
