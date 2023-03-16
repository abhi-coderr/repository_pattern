package com.example.cleanarchitecturedemo.domain.repository

import com.example.cleanarchitecturedemo.data.model.tv.TvShow

interface TvShowRepository {

    suspend fun getTvShow(): List<TvShow>?

    suspend fun updateTvShow(): List<TvShow>?

}