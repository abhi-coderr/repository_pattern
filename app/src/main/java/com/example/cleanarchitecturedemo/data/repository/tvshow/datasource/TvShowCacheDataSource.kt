package com.example.cleanarchitecturedemo.data.repository.tvshow.datasource

import com.example.cleanarchitecturedemo.data.model.tv.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShow: List<TvShow>)

}