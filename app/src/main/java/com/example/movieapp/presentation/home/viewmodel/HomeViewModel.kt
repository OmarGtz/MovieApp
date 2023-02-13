package com.example.movieapp.presentation.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.presentation.home.model.MovieUI
import com.example.movieapp.presentation.home.model.toUI
import kotlinx.coroutines.launch

class HomeViewModel(val repository: MovieRepository): ViewModel() {

    private val _movies: MutableLiveData<List<MovieUI>> = MutableLiveData()
    val movies: LiveData<List<MovieUI>> = _movies

    fun getMovies() {
        viewModelScope.launch {
            val result = repository.getMovies()
            when (result) {
                is MovieResult.Error -> { Log.e("ERROR", result.error.message ?: "Error desconocido") }
                is MovieResult.Success -> {
                    _movies.value = result.data.map { it.toUI() }
                }
            }
        }
    }
}