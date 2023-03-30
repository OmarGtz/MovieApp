package com.example.movieapp.presentation.detail

import com.example.movieapp.domain.entities.Movie

data class MovieDetailUI(
    val title: String,
    val backdropPath: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val votesCount: Int
)

fun Movie.toUIDetail(): MovieDetailUI{
    return MovieDetailUI(
        title = this.title,
        backdropPath = this.backdropPath,
        overview = this.movieOverview,
        posterPath = this.posterPath,
        releaseDate = "",
        votesCount = this.voteCount
    )
}
