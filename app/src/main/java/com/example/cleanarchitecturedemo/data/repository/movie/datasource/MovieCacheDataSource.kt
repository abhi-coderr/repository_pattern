package com.example.cleanarchitecturedemo.data.repository.movie.datasource

import com.example.cleanarchitecturedemo.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMovieFromCache(): List<Movie>
    suspend fun saveMovieToCache(movie: List<Movie>)
}