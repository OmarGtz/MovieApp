package com.example.movieapp.domain.entities

import java.util.Date

data class Movie(
    val adult: Boolean,
    val backdropPath: String,
    val id: Int,
    private val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: Date,
    val title: String,
    val video: Boolean,
    val voteCount: Int
) {

    // No se deben de mostrar las peliculas para adultos
    // overview solo debe temer 250 caracteres
    // Solo mostrar las peliculas que tienen video

    private val overviewMax = 0 until 200

    val movieOverview = overview.substring(overviewMax)

    fun isAdult() = adult

    fun hasVideo() = video

}
