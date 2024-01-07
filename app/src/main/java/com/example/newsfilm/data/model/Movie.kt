package com.example.newsfilm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "popular_movies")
data class Movie(

//SerializedName is You can make a change in the name of the existing item json ex
// id is in json id but now we can change name by SerializedName type id and val type any world

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