package com.example.movieapp

import android.app.Application
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.di.ServiceLocator

class MovieApp: Application() {

    val movieRepository: MovieRepository
    get() = ServiceLocator.provideRepository()

    override fun onCreate() {
        super.onCreate()
    }

}