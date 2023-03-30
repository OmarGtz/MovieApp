package com.example.movieapp.presentation.home.model

import com.example.movieapp.data.model.MovieDTO
import com.example.movieapp.domain.entities.Movie
import com.example.movieapp.utils.toMovieUrl

data class MovieUI(
    val id: String,
    val imageUrl: String
)

fun Movie.toUI(): MovieUI {
    return MovieUI(
        id = this.id.toString(),
        imageUrl = this.posterPath.toMovieUrl()
    )
}