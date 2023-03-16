package com.example.cleanarchitecturedemo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturedemo.data.model.tv.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShowToDB(tvShow: List<TvShow>)

    @Query("DELETE FROM tv_show_db")
    suspend fun deleteTvShow()

    @Query("SELECT * FROM tv_show_db")
    suspend fun getTvShows(): List<TvShow>
}