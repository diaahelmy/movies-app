package com.example.newsfilm.data.datasource

import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate

interface MovieLocalDataSource {

    suspend fun getMovieFromDB():List<Movie>
    suspend fun getMovieFromDB2():List<MovieRate>

    suspend fun saveMovieToDB(movie:List<Movie>)
    suspend fun saveMovieToDB2(movie:List<MovieRate>)

    suspend fun clearAll()

    suspend fun clearAll2()
}