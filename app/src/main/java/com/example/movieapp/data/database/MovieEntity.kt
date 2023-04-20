package com.example.movieapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey @ColumnInfo("id") val id: Int,
    @ColumnInfo("backdrop_path") val backdropPath: String,
    @ColumnInfo("overview" )private val overview: String,
    @ColumnInfo("popularity") val popularity: Double,
    @ColumnInfo("poster_path" )val posterPath: String,
    @ColumnInfo("release_date") val releaseDate: String,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("vote_count") val voteCount: Int
)


