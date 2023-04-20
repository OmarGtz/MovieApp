package com.example.movieapp.data.database

import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<MovieEntity>

    @Insert
    fun insetMovie(movieEntity: MovieEntity): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetMovie(movie: List<MovieEntity>): Int

    @Delete
    fun deleteMovies(movies: List<MovieEntity>)

}