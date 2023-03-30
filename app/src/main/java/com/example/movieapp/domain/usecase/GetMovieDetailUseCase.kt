package com.example.movieapp.domain.usecase

import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.domain.entities.Movie
import javax.inject.Inject

open class GetMovieDetailUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(id: String): MovieResult<Movie> {
        return movieRepository.getMovieDetail(id)
    }

}