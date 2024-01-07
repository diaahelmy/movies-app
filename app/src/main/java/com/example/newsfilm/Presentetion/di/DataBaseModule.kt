package com.example.newsfilm.Presentetion.di

import android.content.Context
import androidx.room.Room
import com.example.newsfilm.data.db.MovieDAO
import com.example.newsfilm.data.db.TMDPDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun providerMovieDataBase(context: Context): TMDPDataBase {
        return Room.databaseBuilder(context, TMDPDataBase::class.java, "tmdbclient").build()


    }

    @Singleton
    @Provides
    fun providerMovieDao(tmdpDataBase: TMDPDataBase): MovieDAO {
        return tmdpDataBase.getMoviesDao()


    }
}