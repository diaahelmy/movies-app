package com.example.newsfilm.data.datasourceimpl

import com.example.newsfilm.data.datasource.MovieCacheDataSource
import com.example.newsfilm.data.model.Movie

class MovieCacheDataSourceIMPL : MovieCacheDataSource {

    private var movielist = ArrayList<Movie>()

    // arralist fast menu in users
    override suspend fun getmoviesFromCache(): List<Movie> {
        return movielist
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movielist.clear()
        movielist = ArrayList(movies)

    }
}