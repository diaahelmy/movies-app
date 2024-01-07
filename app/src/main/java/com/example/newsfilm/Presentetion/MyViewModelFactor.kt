package com.example.newsfilm.Presentetion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsfilm.domian.usecases.GetMovieUseCase
import com.example.newsfilm.domian.usecases.UpdateMovieUseCase

class MyViewModelFactor(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase,

    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(getMovieUseCase, updateMovieUseCase) as T
    }

}