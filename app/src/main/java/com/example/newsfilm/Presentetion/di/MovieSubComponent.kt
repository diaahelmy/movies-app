package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.Presentetion.MainActivity
import com.example.newsfilm.Presentetion.MainActivity2
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])

interface MovieSubComponent {

    fun inject(movieActivity: MainActivity)
    fun inject2(movieActivity: MainActivity2)


    @Subcomponent.Factory
    interface Factory{
        fun    create():MovieSubComponent


    }
}