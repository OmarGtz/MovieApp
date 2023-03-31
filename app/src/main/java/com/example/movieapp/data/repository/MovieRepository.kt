package com.example.movieapp.data.repository


import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.domain.entities.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun getMovieDetail(id: String): Movie
}