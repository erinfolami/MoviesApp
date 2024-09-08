package com.example.moviesapp.data.di

import com.example.moviesapp.data.repository.local.LocalMoviesAppRepository
import com.example.moviesapp.data.repository.local.LocalMoviesAppRepositoryImpl
import com.example.moviesapp.data.repository.OfflineFirstMoviesAppRepository
import com.example.moviesapp.data.repository.OfflineFirstMoviesAppRepositoryImpl
import com.example.moviesapp.data.repository.remote.RemoteMoviesAppRepositoryImpl
import com.example.moviesapp.data.repository.remote.RemoteMoviesAppRepository
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
    abstract fun bindsRemoteMovieAppRepository(
        remoteMoviesAppRepositoryImpl: RemoteMoviesAppRepositoryImpl
    ): RemoteMoviesAppRepository

    @Binds
    abstract fun bindsLocalMovieAppRepository(
        localMoviesAppRepositoryImpl: LocalMoviesAppRepositoryImpl
    ): LocalMoviesAppRepository

    @Binds
    abstract fun bindsOfflineFirstMoviesAppRepository(
        offlineFirstMoviesAppRepositoryImpl: OfflineFirstMoviesAppRepositoryImpl
    ): OfflineFirstMoviesAppRepository

    @Binds
    abstract fun bindsMovieAppDataSource(
        moviesAppDataSourceImpl: MoviesRemoteDataSourceImpl
    ): MoviesRemoteDataSource

}