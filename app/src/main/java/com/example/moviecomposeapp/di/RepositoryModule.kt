package com.example.moviecomposeapp.di

import com.example.moviecomposeapp.network.MovieApi
import com.example.moviecomposeapp.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieApi: MovieApi
    ): MovieRepository = MovieRepository(movieApi)
}