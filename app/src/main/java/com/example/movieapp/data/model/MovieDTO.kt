package com.example.movieapp.data.model

import com.example.movieapp.domain.entities.Movie
import java.util.Date

data class MovieDTO(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MovieDTO.toDomain(): Movie {
    return Movie(
        adult = adult,
        backdropPath = backdrop_path,
        id = id,
        overview = overview,
        popularity = popularity,
        posterPath = poster_path,
        releaseDate = Date(),
        title = title,
        video = video,
        voteCount = vote_count
    )
}