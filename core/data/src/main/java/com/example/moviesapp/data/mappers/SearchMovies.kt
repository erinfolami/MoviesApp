package com.example.moviesapp.data.mappers

import com.example.moviesapp.model.data.SearchMovies
import com.example.moviesapp.network.model.SearchMoviesDTO


fun SearchMoviesDTO.asExternalModel(): List<SearchMovies> {
    return searchResults.map { result ->
        SearchMovies(
            adult = result.adult,
            backdropPath = result.backdropPath,
            id = result.id,
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