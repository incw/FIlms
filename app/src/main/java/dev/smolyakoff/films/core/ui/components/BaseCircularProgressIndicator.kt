package dev.smolyakoff.films.core.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseCircularProgressIndicator(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier.size(48.dp),
        color = MaterialTheme.colorScheme.tertiary
    )
}