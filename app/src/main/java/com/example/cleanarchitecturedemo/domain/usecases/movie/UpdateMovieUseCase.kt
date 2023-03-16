package com.example.cleanarchitecturedemo.domain.usecases.movie

import com.example.cleanarchitecturedemo.data.model.movie.Movie
import com.example.cleanarchitecturedemo.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}

