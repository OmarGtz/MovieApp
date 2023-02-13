package com.example.movieapp.utils

private const val IMAGE_URL_BASE = "https://image.tmdb.org/t/p/w500"

fun String.toMovieUrl(): String {
    return "$IMAGE_URL_BASE$this"
}
