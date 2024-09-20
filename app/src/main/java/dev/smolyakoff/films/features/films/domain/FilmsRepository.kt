package dev.smolyakoff.films.features.films.domain

import kotlinx.coroutines.flow.StateFlow

interface FilmsRepository {

    val cached: StateFlow<FilmModel>

    suspend fun fetchFilms()
}