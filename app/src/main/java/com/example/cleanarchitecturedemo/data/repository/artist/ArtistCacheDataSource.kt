package com.example.cleanarchitecturedemo.data.repository.artist

import com.example.cleanarchitecturedemo.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artist: List<Artist>)
}