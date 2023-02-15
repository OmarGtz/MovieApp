package com.example.movieapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.presentation.detail.MovieDetailViewModel
import com.example.movieapp.presentation.home.viewmodel.HomeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        with(modelClass) {
            return when {
                isAssignableFrom(HomeViewModel::class.java) -> {
                    HomeViewModel(repository)
                }
                isAssignableFrom(MovieDetailViewModel::class.java) -> {
                    MovieDetailViewModel(repository)
                }
                else -> {
                    throw IllegalArgumentException("Unknown vieMmodel class")
                }
            } as T
        }
    }
}