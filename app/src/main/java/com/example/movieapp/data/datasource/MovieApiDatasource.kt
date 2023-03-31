package com.example.movieapp.data.datasource

import com.example.movieapp.data.api.MovieApi
import com.example.movieapp.data.model.*
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieApiDatasource @Inject constructor(val api: MovieApi): MovieDatasource {

    override suspend fun getMovies(): ApiResponse<DiscoverResponse>{
        return api.discoverMovies().handleResponse()
        }


    override suspend fun getMovieDetail(id: String): ApiResponse<MovieDetailDTO> {
                return api.getMovieDetail(id).handleResponse()
    }
}