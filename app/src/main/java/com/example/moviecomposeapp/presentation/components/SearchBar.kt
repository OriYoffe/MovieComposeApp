package com.example.moviecomposeapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        value = query,
        onValueChange = { onQueryChanged(it) },
        label = { Text(text = "Search") },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSurface,
            focusedIndicatorColor = Color.Magenta,
            backgroundColor = MaterialTheme.colors.surface
        ),

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),

        keyboardActions = KeyboardActions(
            onSearch = {
                onExecuteSearch()
                keyboardController?.hideSoftwareKeyboard()
            }),

        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search icon"
            )
        })
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(
        query = "Some Text",
        onQueryChanged = {},
        onExecuteSearch = {}
    )
}