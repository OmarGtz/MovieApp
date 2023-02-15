package com.example.movieapp.data.api

import com.example.movieapp.data.model.DiscoverResponse
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("discover/movie?api_key=3b56ba0ef89cf0df471b8463860b0aeb")
    suspend fun discoverMovies(): DiscoverResponse

    @GET("movie/{id}?api_key=3b56ba0ef89cf0df471b8463860b0aeb")
    suspend fun getMovieDetail(@Path("id") id: String): MovieDetailDTO

}
