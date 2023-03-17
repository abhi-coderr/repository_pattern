package com.example.cleanarchitecturedemo.data.repository.artist

import android.util.Log
import com.example.cleanarchitecturedemo.data.model.artist.Artist
import com.example.cleanarchitecturedemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.cleanarchitecturedemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cleanarchitecturedemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cleanarchitecturedemo.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newList = getArtistFromAPI()
        artistLocalDataSource.clearAllArtistToDB()
        artistLocalDataSource.saveArtistToDB(newList)
        artistCacheDataSource.saveArtistToCache(newList)
        return newList
    }

    private suspend fun getArtistFromAPI(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: java.lang.Exception) {
            Log.i("myLogFromArtistAPI", e.message.toString())
        }

        return artistList
    }

    private suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        } catch (e: java.lang.Exception) {
            Log.i("myTagArtistFromDB", e.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }

        return artistList
    }

    private suspend fun getArtistFromCache(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (e: java.lang.Exception) {
            Log.i("myTagArtistFromCache", e.message.toString())
        }

        if (artistList.isNotEmpty()) {

            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)

        }

        return artistList
    }
}