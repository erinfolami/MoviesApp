package com.example.moviesapp.network.di

import com.example.moviesapp.network.datasource.MoviesRemoteDataSource
import com.example.moviesapp.network.datasource.MoviesRemoteDataSourceImpl
import com.example.moviesapp.network.retrofit.MovieApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(networkJson: Json): Retrofit {
        val token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0NzMzNmJiMDc3ZWI0ZjI2" +
                "ZWY1MWQ2Zjk1N2E2ZTk1OSIsIm5iZiI6MTcyNDc4NzkyNC43MzM3MjMsInN1YiI6IjYwZm" +
                "YwZTI5Y2VlNDgxMDAyZGQzYzA5ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ" +
                ".yur5MsNkFlY65n7NQ6cOybhilzXTSsltGc6PND_l5xA"

        val client = OkHttpClient.Builder()
            .addInterceptor { chain: Interceptor.Chain ->
                val request: Request = chain.request().newBuilder()
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", token)
                    .build()
                chain.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }


}