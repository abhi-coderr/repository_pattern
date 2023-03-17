package com.example.cleanarchitecturedemo.data.repository.artist.datasourceimpl

import com.example.cleanarchitecturedemo.data.api.TMDBService
import com.example.cleanarchitecturedemo.data.model.artist.ArtistList
import com.example.cleanarchitecturedemo.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey = apiKey)
    }
}