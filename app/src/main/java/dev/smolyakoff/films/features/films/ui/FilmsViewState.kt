package dev.smolyakoff.films.features.films.ui

import dev.smolyakoff.films.features.films.domain.Film

sealed class FilmsViewState {
    data object Loading : FilmsViewState()
    data object Error: FilmsViewState()
    data class Success(
        val films: List<Film>,
        val genres: List<String>
    ) : FilmsViewState()
}