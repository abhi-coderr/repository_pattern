package com.example.cleanarchitecturedemo.data.repository.artist.datasourceimpl

import com.example.cleanarchitecturedemo.data.database.dao.ArtistDao
import com.example.cleanarchitecturedemo.data.model.artist.Artist
import com.example.cleanarchitecturedemo.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private var dao: ArtistDao
) : ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return dao.getArtist()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertArtistToDB(artist = artist)
        }
    }

    override suspend fun clearAllArtistToDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteArtist()
        }
    }
}