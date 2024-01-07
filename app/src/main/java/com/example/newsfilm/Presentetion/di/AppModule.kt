package com.example.newsfilm.Presentetion.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class])
class AppModule(private val context: Context) {


    @Singleton
    @Provides
    fun providerApplicationContext():Context{
        return context.applicationContext
    }

}