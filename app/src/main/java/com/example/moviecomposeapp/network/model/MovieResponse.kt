package com.example.moviecomposeapp.network.model

import com.example.moviecomposeapp.business.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>
)