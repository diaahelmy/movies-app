package com.example.newsfilm.domian.repository

import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate

interface MovieRepository {

    suspend fun getMovie():List<Movie>
    suspend fun getMovie2(): List<MovieRate>

    suspend fun updateMovie():List<Movie>

    suspend fun updateMovie2(): List<MovieRate>

}