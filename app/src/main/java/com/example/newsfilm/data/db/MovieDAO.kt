package com.example.newsfilm.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savemovie(moviesList: List<Movie>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savemovie2(moviesList: List<MovieRate>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("DELETE FROM rate_movies")
    suspend fun deleteAllMovies2()

    @Query("SELECT* FROM  popular_movies ")
    suspend fun getMovies(): List<Movie>

    @Query("SELECT* FROM  rate_movies ")
    suspend fun getMovie2(): List<MovieRate>
}