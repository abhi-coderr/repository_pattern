package com.example.cleanarchitecturedemo.data.repository.movie.datasourceimpl

import com.example.cleanarchitecturedemo.data.database.dao.MovieDao
import com.example.cleanarchitecturedemo.data.model.movie.Movie
import com.example.cleanarchitecturedemo.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val dao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return dao.getMovies()
    }

    override suspend fun savedMovieToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertMoviesToDB(movie)
        }
    }

    override suspend fun clearAllMovieFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteMovies()
        }
    }
}