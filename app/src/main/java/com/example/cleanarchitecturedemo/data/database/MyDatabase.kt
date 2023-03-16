package com.example.cleanarchitecturedemo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecturedemo.data.database.dao.ArtistDao
import com.example.cleanarchitecturedemo.data.database.dao.MovieDao
import com.example.cleanarchitecturedemo.data.database.dao.TvShowDao
import com.example.cleanarchitecturedemo.data.model.artist.Artist
import com.example.cleanarchitecturedemo.data.model.movie.Movie
import com.example.cleanarchitecturedemo.data.model.tv.TvShow

@Database(
    [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}