package com.example.cleanarchitecturedemo.data.repository.movie.datasourceimpl

import com.example.cleanarchitecturedemo.data.model.movie.Movie
import com.example.cleanarchitecturedemo.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMovieFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }

}