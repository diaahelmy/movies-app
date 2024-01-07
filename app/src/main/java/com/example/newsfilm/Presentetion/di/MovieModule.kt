package com.example.newsfilm.Presentetion.di

import com.example.newsfilm.Presentetion.MyViewModelFactor
import com.example.newsfilm.domian.usecases.GetMovieUseCase
import com.example.newsfilm.domian.usecases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides


@Module
class MovieModule {

    @Provides
    @MovieScope
fun providerMovieViewModelFactory(getMovieUseCase: GetMovieUseCase, updateMovieUseCase: UpdateMovieUseCase):MyViewModelFactor{
    return MyViewModelFactor(getMovieUseCase,updateMovieUseCase)



}

}