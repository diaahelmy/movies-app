package com.example.newsfilm.data.datasource

import com.example.newsfilm.data.model.Movie

interface MovieCacheDataSource {

    suspend fun getmoviesFromCache():List<Movie>

    suspend fun saveMoviesToCache(movies:List<Movie>)
}