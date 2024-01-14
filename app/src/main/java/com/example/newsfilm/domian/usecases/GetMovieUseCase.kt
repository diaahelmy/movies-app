package com.example.newsfilm.domian.usecases

import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate
import com.example.newsfilm.domian.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie> = movieRepository.getMovie()
    suspend fun execute2():List<MovieRate> = movieRepository.getMovie2()
}