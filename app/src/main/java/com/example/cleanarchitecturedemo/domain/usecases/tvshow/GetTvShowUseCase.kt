package com.example.cleanarchitecturedemo.domain.usecases.tvshow

import com.example.cleanarchitecturedemo.data.model.tv.TvShow
import com.example.cleanarchitecturedemo.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? =
        tvShowRepository.getTvShow()

}