package com.example.newsfilm.data.datasource

import com.example.newsfilm.data.model.MoviesList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovie():Response<MoviesList>
}