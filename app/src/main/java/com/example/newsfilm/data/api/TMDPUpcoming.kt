package com.example.newsfilm.data.api

import com.example.newsfilm.data.model.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDPUpcoming {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query(
            "api_key"

        )apikey:String

    ): Response<MoviesList>
}
