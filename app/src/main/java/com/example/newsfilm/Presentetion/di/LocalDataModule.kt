package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.data.datasource.MovieLocalDataSource
import com.example.newsfilm.data.db.MovieDAO
import com.example.newsfilm.data.datasourceimpl.MovieLocalDataSourceIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun providerMovieLocaleDataSource(movieDao: MovieDAO):MovieLocalDataSource {
        return MovieLocalDataSourceIMPL(movieDao)


    }

}