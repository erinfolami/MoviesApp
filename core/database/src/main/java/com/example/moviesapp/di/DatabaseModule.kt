package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.MoviesAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesMoviesAppDatabase(
        @ApplicationContext context: Context,
    ): MoviesAppDatabase = Room.databaseBuilder(
        context,
        MoviesAppDatabase::class.java,
        "moviesapp-database",
    ).build()
}
