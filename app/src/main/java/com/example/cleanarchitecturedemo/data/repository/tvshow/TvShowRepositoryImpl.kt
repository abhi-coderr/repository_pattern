package com.example.cleanarchitecturedemo.data.repository.tvshow

import android.util.Log
import com.example.cleanarchitecturedemo.data.model.tv.TvShow
import com.example.cleanarchitecturedemo.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.cleanarchitecturedemo.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.cleanarchitecturedemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.cleanarchitecturedemo.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource,
) : TvShowRepository {
    override suspend fun getTvShow(): List<TvShow>? {
        return getTVShowFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        val newCacheList = getTVShowFromAPI()
        tvShowLocalDataSource.clearAllTvShowFromDB()
        tvShowLocalDataSource.saveTvShowToDB(newCacheList)
        tvShowCacheDataSource.saveTvShowToCache(newCacheList)
        return newCacheList
    }

    private suspend fun getTVShowFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("myTagTVShowFromAPI", e.message.toString())
        }

        return tvShowList
    }

    private suspend fun getTVShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        } catch (e: Exception) {
            Log.i("myTagTVShowFromDB", e.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTVShowFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }

        return tvShowList
    }

    private suspend fun getTVShowFromCache(): List<TvShow> {

        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (e: Exception) {
            Log.i("myTagTvShowFromCache", e.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTVShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }

        return tvShowList
    }

}