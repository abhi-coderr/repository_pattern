package com.example.cleanarchitecturedemo.data.repository.tvshow

import android.util.Log
import com.example.cleanarchitecturedemo.data.model.tv.TvShow
import com.example.cleanarchitecturedemo.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource,
) : TvShowRepository {
    override suspend fun getTvShow(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    suspend fun getTVShowFromAPI(): List<TvShow> {
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

    suspend fun getTVShowFromDB(): List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        return tvShowList
    }



}