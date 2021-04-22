package com.example.moviecomposeapp.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MovieFragment {

    @Preview
    @Composable
    fun TestCompose() {
        Button(onClick = { /*TODO*/ }) {
            Column() {

                Text(text = "Click Me")

                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = "Icon"
                )

            }

        }
    }
}