package com.example.movieapp.data.model.moviedetail

import com.example.movieapp.domain.entities.Movie
import java.util.*

data class MovieDetailDTO(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongsToCollection,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MovieDetailDTO.toDomain(): Movie {
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