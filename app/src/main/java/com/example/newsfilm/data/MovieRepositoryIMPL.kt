package com.example.newsfilm.data

import com.example.newsfilm.data.datasource.MovieCacheDataSource
import com.example.newsfilm.data.datasource.MovieLocalDataSource
import com.example.newsfilm.data.datasource.MovieRemoteDataSource
import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.domian.repository.MovieRepository

class MovieRepositoryIMPL(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,

    ) : MovieRepository {


    override suspend fun getMovie(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovie(): List<Movie> {
        val newListMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListMovies)
        movieCacheDataSource.saveMoviesToCache(newListMovies)
        return newListMovies

    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovie()
            val body = response.body()
            if (body != null) {

                movieList = body.movies

            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList
    }

    private suspend fun getMoviesFromROOM(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMovieFromDB()

        } catch (_: Exception) {


        }
        if (movieList.isNotEmpty()) {

            return movieList

        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getmoviesFromCache()
        } catch (_: Exception) {

        }
        if (movieList.isNotEmpty()) {
            return movieList

        } else {
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movieList)

        }
        return movieList
    }

}