package com.example.cleanarchitecturedemo.data.repository.tvshow

import com.example.cleanarchitecturedemo.data.model.tv.TvShow
import com.example.cleanarchitecturedemo.domain.repository.TvShowRepository

class TvShowRepositoryImpl: TvShowRepository {
    override suspend fun getTvShow(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        TODO("Not yet implemented")
    }
}