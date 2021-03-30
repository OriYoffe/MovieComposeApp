package com.example.moviecomposeapp.presentation.ui.movie_search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecomposeapp.business.model.Movie
import com.example.moviecomposeapp.repository.MovieRepository
import com.example.moviecomposeapp.util.API_KEY
import com.example.moviecomposeapp.util.LANGUAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel
@Inject
constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    // if we want to use the recipes we will usually do something like
    //   private val _recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    //   val recipes: LiveData<List<Recipe>> = _recipes

    // but for Compose there is MutableState
    val movies: MutableState<List<Movie>> = mutableStateOf(listOf())

    val query = mutableStateOf("lord")

    val loading = mutableStateOf(false)

    init {
        newSearch()
    }

    fun newSearch() {
        viewModelScope.launch {
            loading.value = true
            movies.value = movieRepository.searchMovie(API_KEY, LANGUAGE, query.value)
            loading.value = false
        }
    }

}