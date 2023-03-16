package com.example.cleanarchitecturedemo.data.repository.movie

import com.example.cleanarchitecturedemo.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}