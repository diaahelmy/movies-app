package com.example.newsfilm.data.datasourceimpl

import com.example.newsfilm.data.datasource.MovieLocalDataSource
import com.example.newsfilm.data.db.MovieDAO
import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceIMPL(private val movieDAO: MovieDAO) : MovieLocalDataSource {
    override suspend fun getMovieFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun getMovieFromDB2(): List<MovieRate> {
        return movieDAO.getMovie2()
    }

    override suspend fun saveMovieToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.savemovie(movie)
        }
    }

    override suspend fun saveMovieToDB2(movie: List<MovieRate>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.savemovie2(movie)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {

             movieDAO.deleteAllMovies()
        }
    }

    override suspend fun clearAll2() {
        CoroutineScope(Dispatchers.IO).launch {

            movieDAO.deleteAllMovies2()
        }    }

}