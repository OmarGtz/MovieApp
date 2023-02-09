package com.example.movieapp.utils

import androidx.fragment.app.Fragment
import com.example.movieapp.MovieApp

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as MovieApp).movieRepository
    return ViewModelFactory(repository)
}