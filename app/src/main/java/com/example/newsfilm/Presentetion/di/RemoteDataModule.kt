package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.data.api.TMDP
import com.example.newsfilm.data.datasource.MovieRemoteDataSource
import com.example.newsfilm.data.datasourceimpl.MovieRemoteDataSourceIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apikey : String ) {

    @Provides
    @Singleton
    fun providerRemoteDataSource(tmdbService:TMDP):MovieRemoteDataSource{
        return MovieRemoteDataSourceIMPL(tmdbService,apikey)


    }
}