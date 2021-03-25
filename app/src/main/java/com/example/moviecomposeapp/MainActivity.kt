package com.example.moviecomposeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HelloGini()
        }
    }

    @Preview
    @Composable
    fun HelloGini() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Hello Gini",
                fontSize = 24.sp,
                color = Color.Magenta
            )

            Spacer(modifier = Modifier.padding(16.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Click Me")

                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = "Icon"
                )
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Text(
                text = "Bye Gini",
                fontSize = 18.sp,
                color = Color.Red
            )
        }
    }
}