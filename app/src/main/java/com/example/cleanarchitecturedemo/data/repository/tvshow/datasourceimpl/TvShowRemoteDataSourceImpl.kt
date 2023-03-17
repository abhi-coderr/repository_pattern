package com.example.cleanarchitecturedemo.data.repository.tvshow.datasourceimpl

import com.example.cleanarchitecturedemo.data.api.TMDBService
import com.example.cleanarchitecturedemo.data.model.tv.TvShowList
import com.example.cleanarchitecturedemo.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShow(): Response<TvShowList> =
        tmdbService.getPopularTv(apiKey = apiKey)
}