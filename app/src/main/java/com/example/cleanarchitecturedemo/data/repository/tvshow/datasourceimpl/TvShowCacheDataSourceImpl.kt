package com.example.cleanarchitecturedemo.data.repository.tvshow.datasourceimpl

import com.example.cleanarchitecturedemo.data.model.tv.TvShow
import com.example.cleanarchitecturedemo.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}