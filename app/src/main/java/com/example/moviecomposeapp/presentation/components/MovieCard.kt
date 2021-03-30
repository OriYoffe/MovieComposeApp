package com.example.moviecomposeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.moviecomposeapp.R
import com.example.moviecomposeapp.business.model.Movie
import com.example.moviecomposeapp.util.IMAGE_BASE_URL
import com.google.accompanist.glide.GlideImage

@Preview
@Composable
fun PreviewMovieCardCollection(@PreviewParameter(SampleMovieAndClickProvider::class) args: MovieAndClick) {
    MovieCard(movie = args.movie, args.onClick)
}

@Preview
@Composable
fun PreviewMovieCard(@PreviewParameter(SampleMovieProvider::class) movie: Movie) {
    MovieCard(movie = movie)
}

@Composable
fun MovieCard(
    movie: Movie,
    onClick: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp,
        backgroundColor = Color.LightGray
    ) {

        Column {
            movie.posterPath?.let { url ->

                GlideImage(
                    data = IMAGE_BASE_URL + url,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    loading = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_image_24),
                            contentDescription = "loading image"
                        )
                    },
                    fadeIn = true
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Text(text = movie.title)

                    Text(text = movie.releaseDate)

                }

            }
        }


    }

}

class SampleMovieProvider : PreviewParameterProvider<Movie> {

    override val values = sequenceOf(
        Movie(
            123,
            "Seven Samurai",
            "1954-04-26",
            "A samurai answers a village's request for protection after he falls on hard times. The town needs protection from bandits, so the samurai gathers six others to help him teach the people how to defend themselves, and the villagers provide the soldiers with food. A giant battle occurs when 40 bandits attack the village.",
            "/1wCRVLGI7SoTOoDRzWlbt2dMDuy.jpg"
        ),
        Movie(
            25237,
            "Come and See",
            "1985-09-03",
            "The invasion of a village in Byelorussia by German forces sends young Florya into the forest to join the weary Resistance fighters, against his family's wishes. There he meets a girl, Glasha, who accompanies him back to his village. On returning home, Florya finds his family and fellow peasants massacred. His continued survival amidst the brutal debris of war becomes increasingly nightmarish, a battle between despair and hope.",
            "/90A8sXK9QZVJ7Rj8nLdsj5NuO5s.jpg"
        )
    )

    override val count: Int = values.count()
}

class SampleMovieAndClickProvider : CollectionPreviewParameterProvider<MovieAndClick>(
    listOf(
        MovieAndClick(Movie(
            123,
            "Seven Samurai",
            "1954-04-26",
            "A samurai answers a village's request for protection after he falls on hard times. The town needs protection from bandits, so the samurai gathers six others to help him teach the people how to defend themselves, and the villagers provide the soldiers with food. A giant battle occurs when 40 bandits attack the village.",
            "/1wCRVLGI7SoTOoDRzWlbt2dMDuy.jpg"
        ), {})
    )
)

data class MovieAndClick(
    val movie: Movie,
    val onClick: () -> Unit
)