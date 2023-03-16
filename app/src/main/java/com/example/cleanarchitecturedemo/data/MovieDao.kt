package com.example.cleanarchitecturedemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturedemo.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesToDB(movies: List<Movie>)

    @Query(value = "DELETE FROM movie_db")
    suspend fun deleteMovies()

    @Query("SELECT * FROM movie_db")
    suspend fun getMoviesFromDB(movies: List<Movie>)
}