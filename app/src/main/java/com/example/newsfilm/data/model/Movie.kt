package com.example.newsfilm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "popular_movies")

data class Movie(


    @SerializedName("id")
    @PrimaryKey
    val id: Int,

    val overview: String,

    @SerializedName("poster_path")
    val posterpath: String,

    @SerializedName("release_date")
    val release_date: String,

    val title: String,

    )