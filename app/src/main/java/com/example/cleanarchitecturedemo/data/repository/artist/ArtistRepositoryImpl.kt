package com.example.cleanarchitecturedemo.data.repository.artist

import com.example.cleanarchitecturedemo.data.model.artist.Artist
import com.example.cleanarchitecturedemo.domain.repository.ArtistRepository

class ArtistRepositoryImpl : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtist(): List<Artist>? {
        TODO("Not yet implemented")
    }
}