package com.example.newsfilm.data

import android.util.Log
import com.example.newsfilm.data.datasource.MovieCacheDataSource
import com.example.newsfilm.data.datasource.MovieLocalDataSource
import com.example.newsfilm.data.datasource.MovieRemoteDataSource
import com.example.newsfilm.data.datasource.MovieRemoteDataSourceUP
import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate
import com.example.newsfilm.domian.repository.MovieRepository


class MovieRepositoryIMPL(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieremoteDataSourseTmdpup: MovieRemoteDataSourceUP,

    ) : MovieRepository {


    override suspend fun getMovie(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun getMovie2(): List<MovieRate> {
        return getMoviesFromCache2()
    }

    override suspend fun updateMovie(): List<Movie> {
        val newListMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListMovies)
        movieCacheDataSource.saveMoviesToCache(newListMovies)
        return newListMovies

    }

    override suspend fun updateMovie2(): List<MovieRate> {
        val newListMovies = getMoviesFromAPIUp()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB2(newListMovies)
        movieCacheDataSource.saveMoviesToCache2(newListMovies)
        return newListMovies
    }

    private suspend fun getMoviesFromAPIUp(): List<MovieRate> {
        lateinit var movieList2: List<MovieRate>

        try {
            val response2 = movieremoteDataSourseTmdpup.getMovie()

            val body = response2.body()
            if (body != null) {

                movieList2 = body.movies

            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList2

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

        } catch (e: Exception) {
            e.printStackTrace()

        }

        if (movieList.isNotEmpty()) {
        Log.d("diaa","NotEmpty")
            return movieList

        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovieToDB(movieList)
            Log.i("diaa","Empty")

        }
        return movieList
    }

    private suspend fun getMoviesFromROOM2(): List<MovieRate> {
        lateinit var movieList2: List<MovieRate>
        try {
            movieList2 = movieLocalDataSource.getMovieFromDB2()

        } catch (_: Exception) {


        }
        if (movieList2.isNotEmpty()) {

            return movieList2

        } else {
            movieList2 = getMoviesFromAPIUp()
            movieLocalDataSource.saveMovieToDB2(movieList2)
        }
        return movieList2
    }

   private  suspend fun getMoviesFromCache(): List<Movie> {
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

    private suspend fun getMoviesFromCache2(): List<MovieRate> {
        lateinit var movieList2: List<MovieRate>
        try {
            movieList2 = movieCacheDataSource.getmoviesFromCache2()
        } catch (_: Exception) {

        }
        if (movieList2.isNotEmpty()) {
            return movieList2

        } else {
            movieList2 = getMoviesFromROOM2()
            movieCacheDataSource.saveMoviesToCache2(movieList2)

        }
        return movieList2
    }

}