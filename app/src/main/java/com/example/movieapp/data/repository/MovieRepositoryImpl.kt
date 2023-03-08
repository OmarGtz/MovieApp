package com.example.movieapp.data.repository
import com.example.movieapp.data.model.MovieDTO
import com.example.movieapp.data.datasource.MovieDatasource
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val datasource: MovieDatasource): MovieRepository {

    override suspend fun getMovies(): MovieResult<List<MovieDTO>> {
        return datasource.getMovies()
    }

    override suspend fun getMovieDetail(id: String): MovieResult<MovieDetailDTO> {
        return datasource.getMovieDetail(id)
    }

}
