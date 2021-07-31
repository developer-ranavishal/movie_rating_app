package com.example.imdb_app.di

import com.example.imdb_app.constant.BASE_URL
import com.example.imdb_app.model.MovieRepository
import com.example.imdb_app.network.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun createRetrofit(): Retrofit =Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Singleton
    @Provides
    fun createMovieApi(retrofit: Retrofit): MovieApi =retrofit.create(MovieApi::class.java)

    @Singleton
    @Provides
    fun createRepository(moveApi : MovieApi)= MovieRepository(moveApi)
}
