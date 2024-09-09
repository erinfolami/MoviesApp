package com.example.moviesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviesapp.model.data.TrendingMovies

@Entity(tableName = "trending_movies")
data class TrendingMoviesEntity(
    @PrimaryKey val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val mediaType: String,
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


fun TrendingMoviesEntity.asExternalModel() = TrendingMovies(
    id = id,
    adult = adult,
    backdropPath = backdropPath,
    mediaType = mediaType,
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