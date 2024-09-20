package dev.smolyakoff.films.features.films.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.smolyakoff.films.R
import dev.smolyakoff.films.core.ui.components.BaseTopAppBar
import dev.smolyakoff.films.core.ui.components.header
import dev.smolyakoff.films.core.ui.views.LoadingView
import dev.smolyakoff.films.features.films.domain.Film
import dev.smolyakoff.films.features.films.ui.components.FilmCard
import kotlinx.coroutines.launch

@Composable
fun FilmsView(
    modifier: Modifier = Modifier,
    onFilmClick: (Film) -> Unit,
    viewModel: FilmsViewModel
) {

    val coroutineScope = rememberCoroutineScope()

    val error by viewModel.error.collectAsStateWithLifecycle()

    val hostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = error) {
        error?.let {
            coroutineScope.launch {
                val result = hostState
                    .showSnackbar(message = it, actionLabel = "ПОВТОРИТЬ",)
                when (result) {
                    SnackbarResult.Dismissed -> viewModel.clearError()
                    SnackbarResult.ActionPerformed -> {
                        viewModel.retry()
                    }
                }
            }
        }
    }

    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    val selectedGenre by viewModel.selectedCategory.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        topBar = {
            BaseTopAppBar(title = stringResource(id = R.string.films))
        },
        snackbarHost = {
            SnackbarHost(
                hostState = hostState
            ) {
                Snackbar(
                    snackbarData = it,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    containerColor = MaterialTheme.colorScheme.surface,
                    actionColor = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    ) { paddingValues ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(bottom = 16.dp)
        ) {
            when (val state = viewState) {

                FilmsViewState.Loading -> LoadingView()

                is FilmsViewState.Success -> {

                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 8.dp,
                            alignment = Alignment.CenterHorizontally
                        ),
                        verticalArrangement = Arrangement.spacedBy(
                            space = 16.dp,
                            alignment = Alignment.CenterVertically
                        ),
                        columns = GridCells.Fixed(2),
                    ) {

                        header {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Box(
                                    modifier = Modifier
                                        .height(40.dp),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Text(
                                        modifier = Modifier.padding(horizontal = 16.dp),
                                        text = stringResource(id = R.string.category),
                                        color = MaterialTheme.colorScheme.primary,
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }

                                state.genres.forEach { genre ->

                                    val rowBackground = animateColorAsState(
                                        targetValue = if (selectedGenre == genre) {
                                            MaterialTheme.colorScheme.tertiary
                                        } else {
                                            MaterialTheme.colorScheme.background
                                        }, label = "background row color animation"
                                    )

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(40.dp)
                                            .background(rowBackground.value)
                                            .clickable {
                                                viewModel.selectCategory(genre)
                                            }
                                            .padding(horizontal = 16.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = genre,
                                            color = MaterialTheme.colorScheme.primary,
                                            style = MaterialTheme.typography.titleMedium
                                        )
                                    }
                                }
                            }
                        }

                        header {
                            Text(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                text = stringResource(id = R.string.films),
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.titleLarge
                            )
                        }

                        itemsIndexed(
                            items = state.films,
                            key = { _, film -> film.id }
                        ) { index, film ->

                            val isFirstCell = remember {
                                derivedStateOf { index % 2 == 0 }
                            }

                            val horizontalPadding = if (isFirstCell.value) 16.dp else 0.dp

                            val endPadding = if (!isFirstCell.value) 16.dp else 0.dp

                            FilmCard(
                                model = film,
                                modifier = Modifier
                                    .padding(start = horizontalPadding, end = endPadding)
                            ) {
                                onFilmClick(film)
                            }
                        }

                    }
                }

                FilmsViewState.Error -> {}
            }
        }

    }
}