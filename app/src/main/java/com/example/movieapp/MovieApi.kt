package com.example.movieapp

import com.example.movieapp.api.DiscoverResponse
import com.example.movieapp.api.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("discover/movie?api_key=3b56ba0ef89cf0df471b8463860b0aeb")
    suspend fun discoverMovies(): DiscoverResponse

    @GET("movie/{movie_id}?api_key=af04f22f05f6c271b11420c9349c2db9")
    suspend fun detailMovie(
        @Path("movie_id") movie_id:Int
    ): MovieDetail
}