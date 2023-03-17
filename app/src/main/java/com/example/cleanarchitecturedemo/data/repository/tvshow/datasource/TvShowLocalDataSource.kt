package com.example.cleanarchitecturedemo.data.repository.tvshow.datasource

import com.example.cleanarchitecturedemo.data.model.tv.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB():List<TvShow>
    suspend fun saveTvShowToDB(tvShow: List<TvShow>)
    suspend fun clearAllTvShowFromDB()
}