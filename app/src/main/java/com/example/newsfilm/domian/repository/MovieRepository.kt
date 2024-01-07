package com.example.newsfilm.domian.repository

import com.example.newsfilm.data.model.Movie

interface MovieRepository {

    suspend fun getMovie():List<Movie>
    suspend fun updateMovie():List<Movie>

}