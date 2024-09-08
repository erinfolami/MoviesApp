package com.example.moviesapp.model.data


/**
 * External data layer representation of a fully populated moviesApp Trending Result
 */
data class TrendingMovies(
    val id: Int,
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
