package com.example.cleanarchitecturedemo.data.model.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import dagger.hilt.EntryPoint

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>,
)

@Entity(tableName = "artist_db")
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String
)
