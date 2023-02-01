package com.example.movieapp.presentation.home.movie_list_by_category.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.presentation.home.movie_list_by_category.model.MovieUI
import kotlinx.coroutines.launch

class MovieListViewModel(val repository: MovieRepository): ViewModel() {

    private val _movies: MutableLiveData<List<MovieUI>> = MutableLiveData()
    val movies: LiveData<List<MovieUI>> = _movies

    fun getMovies() {
        viewModelScope.launch {
            val result = repository.getMovies()
            when (result) {
                is MovieResult.Error -> TODO()
                is MovieResult.Success -> {
                    _movies.value = result.data.map {
                        MovieUI()
                    }
                }
            }
        }
    }
}