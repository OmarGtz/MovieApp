package com.example.movieapp.di

import com.example.movieapp.data.api.MovieApi
import com.example.movieapp.data.datasource.MovieApiDatasource
import com.example.movieapp.data.datasource.MovieDatasource
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.data.repository.MovieRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/"

object ServiceLocator {

    @Volatile
    var repository: MovieRepository? = null


    fun provideRepository(): MovieRepository {
        return repository ?: createRepository()
    }

    private fun createRepository(): MovieRepository {
        return MovieRepositoryImpl(createRemoteDataSource())
    }

    private fun createRemoteDataSource(): MovieDatasource {
        return MovieApiDatasource(service)
    }

    val service: MovieApi by lazy {
        retrofit.create(MovieApi::class.java)
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

}