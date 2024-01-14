package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.data.api.TMDP
import com.example.newsfilm.data.api.TMDPUpcoming
import com.example.newsfilm.data.datasource.MovieRemoteDataSource
import com.example.newsfilm.data.datasource.MovieRemoteDataSourceUP
import com.example.newsfilm.data.datasourceimpl.MoveRemoteDataSourseTmdpup
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
    @Provides
    @Singleton
    fun providerRemoteDataSourceUP(tmdbUpService:TMDPUpcoming):MovieRemoteDataSourceUP{
        return MoveRemoteDataSourseTmdpup(tmdbUpService,apikey)


    }
}