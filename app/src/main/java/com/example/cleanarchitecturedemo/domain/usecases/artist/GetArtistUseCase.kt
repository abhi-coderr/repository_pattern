package com.example.cleanarchitecturedemo.domain.usecases.artist

import com.example.cleanarchitecturedemo.data.model.artist.Artist
import com.example.cleanarchitecturedemo.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtist()
}