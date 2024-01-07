package com.example.newsfilm.data.datasource

import com.example.newsfilm.data.model.Movie

interface MovieLocalDataSource {

    suspend fun getMovieFromDB():List<Movie>

    suspend fun saveMovieToDB(movie:List<Movie>)

    suspend fun clearAll()


}