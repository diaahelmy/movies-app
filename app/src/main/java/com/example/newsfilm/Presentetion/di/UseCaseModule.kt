package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.domian.repository.MovieRepository
import com.example.newsfilm.domian.usecases.GetMovieUseCase
import com.example.newsfilm.domian.usecases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {


    @Provides
    fun providerGetMovieUseCase(movieRepository: MovieRepository): GetMovieUseCase {
      return  GetMovieUseCase(movieRepository)


    }
    @Provides
    fun providerUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)


    }
}