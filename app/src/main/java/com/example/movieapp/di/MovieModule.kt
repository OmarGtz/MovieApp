package com.example.movieapp.di

import com.example.movieapp.data.datasource.MovieApiDatasource
import com.example.movieapp.data.datasource.MovieDatasource
import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasource.MovieLocalRoomDataSource
import com.example.movieapp.data.repository.MovieRepository
import com.example.movieapp.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class MovieModule {

    @Binds
    abstract fun bindsMovieRepository(impl: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun bindsDataSource(impl: MovieApiDatasource): MovieDatasource

    @Binds
    abstract fun bindMovieLocalDataSource(impl: MovieLocalRoomDataSource): MovieLocalDataSource

}