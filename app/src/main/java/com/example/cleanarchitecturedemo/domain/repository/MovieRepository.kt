package com.example.cleanarchitecturedemo.domain.repository

import com.example.cleanarchitecturedemo.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?

}