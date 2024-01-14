package com.example.newsfilm.Presentetion.di

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules =
    [
        AppModule::class,
        CacheDataModule::class,
        DataBaseModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
    ]
)
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory

}