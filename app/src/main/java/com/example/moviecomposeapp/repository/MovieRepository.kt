package com.example.moviecomposeapp.repository

import com.example.moviecomposeapp.business.model.Movie
import com.example.moviecomposeapp.network.MovieApi
import javax.inject.Inject

class MovieRepository
@Inject
constructor(
    private val movieApi: MovieApi
) {

    suspend fun searchMovie(
        apiKey: String,
        language: String,
        query: String
    ): List<Movie> {
       val response =  movieApi.getMovies(apiKey, language, query)

       return response.movies
    }

}