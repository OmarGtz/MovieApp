package com.example.movieapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapp.data.model.MovieDTO
import com.example.movieapp.domain.entities.Movie
import java.util.Date

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "backdrop_path") val backdropPath: String?,
    @ColumnInfo(name = "overview" ) val overview: String?,
    @ColumnInfo(name = "popularity") val popularity: Double?,
    @ColumnInfo(name = "poster_path" )val posterPath: String?,
    @ColumnInfo(name = "release_date") val releaseDate: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name ="vote_count") val voteCount: Int?
)

fun MovieEntity.toDomain(): Movie {
    return Movie(
        adult = false,
        backdropPath = backdropPath.orEmpty(),
        id = id,
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        posterPath = posterPath.orEmpty(),
        releaseDate = Date(),
        title = title.orEmpty(),
        video = false,
        voteCount = voteCount ?: 0
    )
}