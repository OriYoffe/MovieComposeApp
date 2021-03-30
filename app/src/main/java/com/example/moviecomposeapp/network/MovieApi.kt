package com.example.moviecomposeapp.network

import com.example.moviecomposeapp.network.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {

    // Search for a movie
    @GET("search/movie?")
   suspend fun getMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("query") title: String?
    ): MovieResponse

}