package com.example.moviesapp.data.di

import com.example.moviesapp.data.repository.MoviesAppRepositoryImpl
import com.example.moviesapp.data.repository.MoviesAppRepository
import com.example.moviesapp.network.datasource.MoviesRemoteDataSource
import com.example.moviesapp.network.datasource.MoviesRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsMovieAppRepository(
        movieAppRepositoryImpl: MoviesAppRepositoryImpl
    ): MoviesAppRepository


    @Binds
    abstract fun bindsMovieAppDataSource(
        moviesAppDataSourceImpl: MoviesRemoteDataSourceImpl
    ): MoviesRemoteDataSource

}