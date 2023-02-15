package com.example.movieapp.data.datasource

import com.example.movieapp.data.model.MovieDTO
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO

interface MovieDatasource {
   suspend fun getMovies(): MovieResult<List<MovieDTO>>
   suspend fun getMovieDetail(id: String): MovieResult<MovieDetailDTO>
}
