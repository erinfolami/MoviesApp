package com.example.moviesapp.data.model

import com.example.moviesapp.model.TrendingMoviesEntity
import com.example.moviesapp.network.model.TrendingMoviesDTO

fun TrendingMoviesDTO.asEntityList(): List<TrendingMoviesEntity> {
    return trendingResults.map { result ->
        TrendingMoviesEntity(
            id = result.id,
            adult = result.adult,
            backdropPath = result.backdropPath,
            mediaType = result.mediaType,
            originalLanguage = result.originalLanguage,
            originalTitle = result.originalTitle,
            overview = result.overview,
            popularity = result.popularity,
            posterPath = result.posterPath,
            releaseDate = result.releaseDate,
            title = result.title,
            video = result.video,
            voteAverage = result.voteAverage,
            voteCount = result.voteCount
        )
    }
}
