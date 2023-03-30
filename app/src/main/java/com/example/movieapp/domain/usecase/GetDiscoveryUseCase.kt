package com.example.movieapp.domain.usecase

import com.example.movieapp.data.model.MovieResult
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.domain.entities.Movie
import javax.inject.Inject

class GetDiscoveryUseCase @Inject constructor(val movieRepository: MovieRepository) {

    suspend operator fun invoke(): MovieResult<List<Movie>> {
        val movies = movieRepository.getMovies()
        when (movies) {
            is MovieResult.Success -> {
                movies.data.filter {
                    !it.isAdult() && it.hasVideo()
                }
            }
                is MovieResult.Error -> {
                    movies
                }
        }
        return movies
    }

}