package com.example.newsfilm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate


@Database(entities = [Movie::class, MovieRate::class], version = 2, exportSchema = false)

abstract class TMDPDataBase : RoomDatabase() {

    abstract fun getMoviesDao(): MovieDAO
    companion object {
        @Volatile
        private var instance: TMDPDataBase? = null
        private val Lock = Any()
        operator fun invoke (context: Context)= instance ?: synchronized(Lock){

            instance ?: createDatabase(context).also{
                instance =it

            }

        }
        private fun createDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            TMDPDataBase::class.java,
            "movie_db"

        ).build()

    }
}