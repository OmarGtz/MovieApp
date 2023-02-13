package com.example.movieapp.presentation.home.model

import com.example.movieapp.data.api.MovieDTO
import com.example.movieapp.utils.toMovieUrl

data class MovieUI(
    val imageUrl: String
)

fun MovieDTO.toUI(): MovieUI {
    return MovieUI(
        imageUrl = this.poster_path.toMovieUrl()
    )
}