package com.example.moviesapp.data.di

import com.example.moviesapp.data.repository.MoviesAppRepositoryImpl
import com.example.moviesapp.domain.repository.MoviesAppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindMovieAppRepository(
        movieAppRepositoryImpl: MoviesAppRepositoryImpl
    ): MoviesAppRepository

}