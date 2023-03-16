package com.example.cleanarchitecturedemo.data.repository.tvshow

import com.example.cleanarchitecturedemo.data.model.tv.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShow: List<TvShow>)
    suspend fun clearAllTvShowFromCache()

}