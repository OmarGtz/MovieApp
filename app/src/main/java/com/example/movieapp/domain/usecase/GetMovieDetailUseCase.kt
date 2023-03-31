package com.example.movieapp.domain.usecase

import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.di.IoDispatcher
import com.example.movieapp.domain.UseCase
import com.example.movieapp.domain.entities.Movie
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

open class GetMovieDetailUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<String, Movie>(dispatcher) {
    override suspend fun execute(params: String): Movie = movieRepository.getMovieDetail(params)

}