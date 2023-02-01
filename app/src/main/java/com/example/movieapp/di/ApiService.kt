package com.example.movieapp.di

import com.example.movieapp.data.api.MovieApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/"

object ApiService {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val service: MovieApi by lazy {
        retrofit.create(MovieApi::class.java)
    }

}