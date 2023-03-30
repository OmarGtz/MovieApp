package com.example.movieapp.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.domain.entities.Movie
import com.example.movieapp.domain.usecase.GetMovieDetailUseCase
import com.example.movieapp.presentation.home.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(val getMovieDetailUseCase: GetMovieDetailUseCase): ViewModel() {

    private val _detail: MutableLiveData<Movie> = MutableLiveData()
    val detail: LiveData<MovieDetailUI> = Transformations.map(_detail) {
        it.toUIDetail()
    }

    fun getDetail(id: String) {
        viewModelScope.launch {
            val result = getMovieDetailUseCase(id)
            when (result) {
                is MovieResult.Success -> {
                    _detail.value = result.data!!
                }
                is MovieResult.Error -> {
                    Log.e("ERROR", result.error.message ?: "Error desconocido")
                }
            }
        }
    }

}