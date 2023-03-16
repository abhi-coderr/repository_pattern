package com.example.cleanarchitecturedemo.data.repository.tvshow

import com.example.cleanarchitecturedemo.data.model.tv.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShow(): Response<TvShowList>
}