package com.example.newsfilm.data.datasourceimpl

import com.example.newsfilm.data.datasource.MovieLocalDataSource
import com.example.newsfilm.data.db.MovieDAO
import com.example.newsfilm.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceIMPL(private val movieDAO: MovieDAO) : MovieLocalDataSource {
    override suspend fun getMovieFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMovieToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.savemovie(movie)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {

             movieDAO.deleteAllMovies()
        }
    }

}