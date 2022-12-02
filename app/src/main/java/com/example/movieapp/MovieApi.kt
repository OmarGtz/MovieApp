package com.example.movieapp

import com.example.movieapp.api.DiscoverResponse
import retrofit2.http.GET

interface MovieApi {

    @GET("discover/movie?api_key=3b56ba0ef89cf0df471b8463860b0aeb")
    suspend fun discoverMovies(): DiscoverResponse

}