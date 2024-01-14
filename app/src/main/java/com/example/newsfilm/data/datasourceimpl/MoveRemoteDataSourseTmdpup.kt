package com.example.newsfilm.data.datasourceimpl

import com.example.newsfilm.data.api.TMDPUpcoming
import com.example.newsfilm.data.datasource.MovieRemoteDataSourceUP
import com.example.newsfilm.data.model.MovieList2
import retrofit2.Response

class MoveRemoteDataSourseTmdpup(
    private val tmdbupservice: TMDPUpcoming,
    private val apikey: String,
) : MovieRemoteDataSourceUP {

    override suspend fun getMovie(): Response<MovieList2> = tmdbupservice.getUpcomingMovies2(apikey)


}