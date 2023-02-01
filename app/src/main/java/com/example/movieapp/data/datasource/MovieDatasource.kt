package com.example.movieapp.data.datasource

import com.example.movieapp.data.api.MovieDTO
import com.example.movieapp.data.model.MovieResult

interface MovieDatasource {
   suspend fun getMovies(): MovieResult<List<MovieDTO>>
}
