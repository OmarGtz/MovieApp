package com.example.movieapp.data.datasource

import com.example.movieapp.data.model.ApiResponse
import com.example.movieapp.data.model.DiscoverResponse
import com.example.movieapp.data.model.MovieDTO
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO

interface MovieDatasource {
   suspend fun getMovies():ApiResponse<DiscoverResponse>
   suspend fun getMovieDetail(id: String): ApiResponse<MovieDetailDTO>

}
