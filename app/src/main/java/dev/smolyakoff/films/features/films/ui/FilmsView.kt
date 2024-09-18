package dev.smolyakoff.films.features.films.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun FilmsView(
    modifier: Modifier = Modifier,
    onFilmClick: () -> Unit
) {
    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Button(onClick = onFilmClick) {
                Text(text = "on film click")
            }
        }
    }
}