package com.example.cleanarchitecturedemo.data

import com.example.cleanarchitecturedemo.data.model.ArtistList
import com.example.cleanarchitecturedemo.data.model.MovieList
import com.example.cleanarchitecturedemo.data.model.TvShow
import com.example.cleanarchitecturedemo.data.model.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTv(
        @Query("api_key") apiKey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(
        @Query("api_key") apiKey: String
    ): Response<ArtistList>

}