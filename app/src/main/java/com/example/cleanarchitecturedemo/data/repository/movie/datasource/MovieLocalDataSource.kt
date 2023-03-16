package com.example.cleanarchitecturedemo.data.repository.movie.datasource

import com.example.cleanarchitecturedemo.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun savedMovieToDB(movie: List<Movie>)
    suspend fun clearAllMovieFromDB()
}