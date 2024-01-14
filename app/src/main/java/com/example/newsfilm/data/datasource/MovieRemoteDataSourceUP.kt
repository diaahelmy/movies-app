package com.example.newsfilm.data.datasource

import com.example.newsfilm.data.model.MovieList2
import retrofit2.Response

interface MovieRemoteDataSourceUP {

    suspend fun getMovie(): Response<MovieList2>
}