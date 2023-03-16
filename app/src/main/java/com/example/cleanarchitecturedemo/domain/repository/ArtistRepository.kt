package com.example.cleanarchitecturedemo.domain.repository

import com.example.cleanarchitecturedemo.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}