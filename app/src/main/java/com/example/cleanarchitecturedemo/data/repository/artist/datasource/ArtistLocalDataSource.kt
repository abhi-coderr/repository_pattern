package com.example.cleanarchitecturedemo.data.repository.artist.datasource

import com.example.cleanarchitecturedemo.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAllArtistToDB()
}