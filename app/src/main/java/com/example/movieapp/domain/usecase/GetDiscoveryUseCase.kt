package com.example.movieapp.domain.usecase

import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.di.IoDispatcher
import com.example.movieapp.domain.UseCase
import com.example.movieapp.domain.entities.Movie
import com.example.movieapp.domain.entities.NotDataFound
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetDiscoveryUseCase @Inject constructor(
    val movieRepository: MovieRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
    ): UseCase<Unit, List<Movie>>(dispatcher) {

    override suspend fun execute(params: Unit): List<Movie> {
        val movies = movieRepository.getMovies()
        if (movies.isEmpty()) {
            throw NotDataFound()
        }
        return movies
    }
}
