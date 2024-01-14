package com.example.newsfilm.data.model

import com.google.gson.annotations.SerializedName

data class MovieList2 (

@SerializedName("results")
val movies: List<MovieRate>,
)
