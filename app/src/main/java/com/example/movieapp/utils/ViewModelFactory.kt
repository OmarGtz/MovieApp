package com.example.movieapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.presentation.home.movie_list_by_category.viewmodel.MovieListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        with(modelClass) {
            return when {
                isAssignableFrom(MovieListViewModel::class.java) -> {
                    MovieListViewModel(repository)
                }
                else -> {
                    throw IllegalArgumentException("Unknown vieMmodel class")
                }
            } as T
        }
    }
}