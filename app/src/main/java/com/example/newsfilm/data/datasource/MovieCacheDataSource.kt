package com.example.newsfilm.data.datasource

import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate

interface MovieCacheDataSource {

    suspend fun getmoviesFromCache():List<Movie>
    suspend fun getmoviesFromCache2():List<MovieRate>

    suspend fun saveMoviesToCache(movies:List<Movie>)
    suspend fun saveMoviesToCache2(movies:List<MovieRate>)

}