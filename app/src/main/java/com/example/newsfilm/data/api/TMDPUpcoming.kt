package com.example.newsfilm.data.api

import com.example.newsfilm.data.model.MovieList2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDPUpcoming {

    @GET("movie/top_rated")
    suspend fun getUpcomingMovies2(
        @Query(
            "api_key"

        )apikey:String

    ): Response<MovieList2>
}
