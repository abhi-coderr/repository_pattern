package com.example.cleanarchitecturedemo.data.repository.movie.datasourceimpl

import com.example.cleanarchitecturedemo.data.api.TMDBService
import com.example.cleanarchitecturedemo.data.model.movie.MovieList
import com.example.cleanarchitecturedemo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovie(
        apiKey = apiKey
    )
}