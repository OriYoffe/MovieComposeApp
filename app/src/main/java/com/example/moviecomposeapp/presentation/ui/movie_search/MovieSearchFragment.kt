package com.example.moviecomposeapp.presentation.ui.movie_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviecomposeapp.presentation.BaseApplication
import com.example.moviecomposeapp.presentation.components.BottomNavigation
import com.example.moviecomposeapp.presentation.components.MovieCard
import com.example.moviecomposeapp.presentation.components.MyProgressIndicator
import com.example.moviecomposeapp.presentation.components.SearchBar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MovieSearchFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewModel: MovieSearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieLSearchCompose()
            }
        }
    }

    @Composable
    fun MovieLSearchCompose() {

        // everytime the movie result changes this val changes
        val movies = viewModel.movies.value

        val query = viewModel.query.value

        val loading = viewModel.loading.value

        Scaffold(
            topBar = {
                SearchBar(
                    query = query,
                    onQueryChanged = { viewModel.query.value = it },
                    onExecuteSearch = { viewModel.newSearch() })
            },

            bottomBar = { BottomNavigation() },
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.background)
            ) {

                LazyColumn {
                    items(items = movies) { movie ->
                        MovieCard(movie = movie, onClick = {})
                    }
                }

                MyProgressIndicator(isDisplayed = loading)
            }
        }
    }

    @Preview
    @Composable
    fun MovieSearchFragmentPreview() {
        MovieLSearchCompose()
    }

}