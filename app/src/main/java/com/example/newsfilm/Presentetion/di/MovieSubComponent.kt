package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.Presentetion.MainActivity
import dagger.Component
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])

interface MovieSubComponent {

    fun inject(movieActivity:MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun    create():MovieSubComponent

    }
}