package com.example.moviesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviesapp.model.data.UpcomingMovies


@Entity(tableName = "upcoming_movies")
data class UpcomingMoviesEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)


fun UpcomingMoviesEntity.asExternalModel() = UpcomingMovies(
    adult = adult,
    backdropPath = backdropPath,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)