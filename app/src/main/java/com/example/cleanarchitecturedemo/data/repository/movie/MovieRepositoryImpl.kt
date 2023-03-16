package com.example.cleanarchitecturedemo.data.repository.movie

import com.example.cleanarchitecturedemo.data.model.movie.Movie
import com.example.cleanarchitecturedemo.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }
}