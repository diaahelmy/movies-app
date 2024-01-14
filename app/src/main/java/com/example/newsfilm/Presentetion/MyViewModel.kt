package com.example.newsfilm.Presentetion


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.newsfilm.domian.usecases.GetMovieUseCase
import com.example.newsfilm.domian.usecases.UpdateMovieUseCase

class MyViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase,

    ) : ViewModel() {
    fun getMovies() = liveData {
        val movielist = getMovieUseCase.execute()
        emit(movielist)

    }

    fun updateMovies() = liveData {
        val movielist = updateMovieUseCase.execute()
        emit(movielist)

    }
    fun getMovies2() = liveData {
        val movielist2 = getMovieUseCase.execute2()
        emit(movielist2)
    }
    fun updateMovies2() = liveData {
        val movielist2 = updateMovieUseCase.execute2()
        emit(movielist2)

    }

}