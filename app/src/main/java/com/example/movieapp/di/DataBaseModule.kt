package com.example.movieapp.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.database.MovieDao
import com.example.movieapp.data.database.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            MovieDataBase::class.java,
            "Movies.db"
        ).build()
    }

    @Provides
    fun providesMovieDao(dataBase: MovieDataBase): MovieDao {
        return dataBase.movieDao()
    }

}