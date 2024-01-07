package com.example.newsfilm.data.model

import com.google.gson.annotations.SerializedName

data class MoviesList(

    @SerializedName("results")
    val movies: List<Movie>,

    )
