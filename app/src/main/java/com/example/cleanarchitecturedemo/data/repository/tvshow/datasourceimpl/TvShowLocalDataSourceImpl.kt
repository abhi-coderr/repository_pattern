package com.example.cleanarchitecturedemo.data.repository.tvshow.datasourceimpl

import com.example.cleanarchitecturedemo.data.database.dao.TvShowDao
import com.example.cleanarchitecturedemo.data.model.tv.TvShow
import com.example.cleanarchitecturedemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TvShowLocalDataSourceImpl(private val dao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowFromDB(): List<TvShow> {
        return dao.getTvShows()
    }

    override suspend fun saveTvShowToDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertTvShowToDB(tvShow = tvShow)
        }
    }

    override suspend fun clearAllTvShowFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteTvShow()
        }
    }
}