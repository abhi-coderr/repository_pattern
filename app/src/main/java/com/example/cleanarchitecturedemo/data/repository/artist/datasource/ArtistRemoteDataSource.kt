package com.example.cleanarchitecturedemo.data.repository.artist.datasource

import com.example.cleanarchitecturedemo.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}