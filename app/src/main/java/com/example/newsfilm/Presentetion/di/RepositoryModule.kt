package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.data.MovieRepositoryIMPL
import com.example.newsfilm.data.datasource.MovieCacheDataSource
import com.example.newsfilm.data.datasource.MovieLocalDataSource
import com.example.newsfilm.data.datasource.MovieRemoteDataSource
import com.example.newsfilm.domian.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule() {

    @Provides
    @Singleton
    fun providerMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource,
    ): MovieRepository {

        return MovieRepositoryIMPL(
            movieRemoteDataSource,
            movieCacheDataSource,
            movieLocalDataSource
        )
    }

}