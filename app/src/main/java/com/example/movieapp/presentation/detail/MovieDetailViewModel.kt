package com.example.movieapp.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.model.moviedetail.MovieDetailDTO
import com.example.movieapp.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieDetailViewModel(val repository: MovieRepository): ViewModel() {

    private val _detail: MutableLiveData<MovieDetailDTO> = MutableLiveData()
    val detail: LiveData<MovieDetailDTO> = _detail

    fun getDetail(id: String) {
        viewModelScope.launch {
            val result = repository.getMovieDetail(id)
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