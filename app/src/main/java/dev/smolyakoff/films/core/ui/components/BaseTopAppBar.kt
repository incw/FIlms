package dev.smolyakoff.films.core.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: @Composable () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                maxLines = 1
            )
        },
        navigationIcon = navigationIcon,
        colors = TopAppBarDefaults
            .centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                titleContentColor = MaterialTheme.colorScheme.onSecondary,
                navigationIconContentColor = MaterialTheme.colorScheme.onSecondary,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondary
            )
    )
}