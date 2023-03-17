package com.example.cleanarchitecturedemo.data.repository.movie

import android.util.Log
import com.example.cleanarchitecturedemo.data.model.movie.Movie
import com.example.cleanarchitecturedemo.data.repository.movie.datasource.MovieCacheDataSource
import com.example.cleanarchitecturedemo.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cleanarchitecturedemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cleanarchitecturedemo.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovie = getMoviesFromAPI()
        movieLocalDataSource.clearAllMovieFromDB()
        movieLocalDataSource.savedMovieToDB(newListOfMovie)
        movieCacheDataSource.saveMovieToCache(newListOfMovie)
        return newListOfMovie
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {

        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    private suspend fun getMovieFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.i("myTagFromDB", e.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.savedMovieToDB(movieList)
        }

        return movieList
    }

    private suspend fun getMovieFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMovieFromCache()
        } catch (e: java.lang.Exception) {
            Log.i("myTagFromCache", e.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMovieFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }

        return movieList
    }

}