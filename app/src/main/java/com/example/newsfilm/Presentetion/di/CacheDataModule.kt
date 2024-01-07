package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.data.datasource.MovieCacheDataSource
import com.example.newsfilm.data.datasourceimpl.MovieCacheDataSourceIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providerMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceIMPL()


    }
}