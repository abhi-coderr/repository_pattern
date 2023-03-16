package com.example.cleanarchitecturedemo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturedemo.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtistToDB(artist: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteArtist()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtist(): List<Artist>
}