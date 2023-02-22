package com.example.movieapp.presentation.detail

import com.example.movieapp.data.model.moviedetail.MovieDetailDTO

data class MovieDetailUI(
    val title: String,
    val backdropPath: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val status: String,
    val porcentCount: Double,
    val votesCount: Int,
    val runtime: Int
)

fun MovieDetailDTO.toUIDetail(): MovieDetailUI{
    return MovieDetailUI(
        title = this.title,
        backdropPath = this.backdrop_path,
        overview = this.overview,
        posterPath = this.poster_path,
        releaseDate = this.release_date,
        status = this.status,
        porcentCount = this.vote_average,
        votesCount = this.vote_count,
        runtime = this.runtime
    )
}
