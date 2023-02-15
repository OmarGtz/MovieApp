package com.example.movieapp.data.datasource

import com.example.movieapp.data.api.MovieApi
import com.example.movieapp.data.model.MovieDTO
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieApiDatasource(val api: MovieApi): MovieDatasource {

    override suspend fun getMovies(): MovieResult<List<MovieDTO>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = api.discoverMovies()
                MovieResult.Success(result.results)

            } catch (e: Exception) {
                MovieResult.Error(e)
            }
        }
    }

    override suspend fun getMovieDetail(id: String): MovieResult<MovieDetailDTO> {
        return withContext(Dispatchers.IO) {
            try {
                val result = api.getMovieDetail(id)
                MovieResult.Success(result)
            } catch (e: Exception) {
                MovieResult.Error(e)
            }
        }
    }
}