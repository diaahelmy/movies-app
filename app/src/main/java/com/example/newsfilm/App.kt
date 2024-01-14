package com.example.newsfilm

import android.app.Application
import com.example.newsfilm.Presentetion.di.AppComponent
import com.example.newsfilm.Presentetion.di.AppModule
import com.example.newsfilm.Presentetion.di.DaggerAppComponent
import com.example.newsfilm.Presentetion.di.Injector
import com.example.newsfilm.Presentetion.di.MovieSubComponent
import com.example.newsfilm.Presentetion.di.NetModule
import com.example.newsfilm.Presentetion.di.RemoteDataModule

class App:Application(),Injector {
     private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule( BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createMovieSubComponent2(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }


}
