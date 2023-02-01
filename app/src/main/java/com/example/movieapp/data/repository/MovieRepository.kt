package com.example.movieapp.data.repository

import com.example.movieapp.data.api.MovieApi
import com.example.movieapp.data.api.MovieDTO
import com.example.movieapp.data.model.MovieResult

interface MovieRepository {
    suspend fun getMovies(): MovieResult<List<MovieDTO>>
    suspend fun getMovieDetail(): MovieDTO

}