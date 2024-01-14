package com.example.newsfilm.data.datasourceimpl

import com.example.newsfilm.data.datasource.MovieCacheDataSource
import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate

class MovieCacheDataSourceIMPL : MovieCacheDataSource {

    private var movielist = ArrayList<Movie>()
    private var movielist2 = ArrayList<MovieRate>()

    // arralist fast menu in users
    override suspend fun getmoviesFromCache(): List<Movie> {
        return movielist
    }

    override suspend fun getmoviesFromCache2(): List<MovieRate> {
        return movielist2
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movielist.clear()
        movielist = ArrayList(movies)

    }

    override suspend fun saveMoviesToCache2(movies: List<MovieRate>) {
        movielist2.clear()
        movielist2 = ArrayList(movies)

    }
}