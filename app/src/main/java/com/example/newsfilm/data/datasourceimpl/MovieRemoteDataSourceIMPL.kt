package com.example.newsfilm.data.datasourceimpl

import com.example.newsfilm.data.api.TMDP
import com.example.newsfilm.data.api.TMDPUpcoming
import com.example.newsfilm.data.datasource.MovieRemoteDataSource
import com.example.newsfilm.data.model.MoviesList
import retrofit2.Response

class MovieRemoteDataSourceIMPL (
    private val tmdbservice:TMDP,
    private val apikey:String
):MovieRemoteDataSource{
    override suspend fun getMovie(): Response<MoviesList> =tmdbservice.getpopularMovies(apikey)

}