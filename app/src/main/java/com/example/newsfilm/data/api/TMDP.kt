package com.example.newsfilm.data.api

import com.example.newsfilm.data.model.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDP {

    @GET("movie/popular")
    suspend fun getpopularMovies(
        @Query(
            "api_key"

        )apikey:String

    ):Response<MoviesList>
}