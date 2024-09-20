package dev.smolyakoff.films.features.films.data

import dev.smolyakoff.films.features.films.api.FilmsService
import dev.smolyakoff.films.features.films.domain.FilmModel
import dev.smolyakoff.films.features.films.domain.FilmsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FilmsRepositoryImpl(
    private val service: FilmsService
) : FilmsRepository {


    private val _cached = MutableStateFlow(FilmModel())
    override val cached: StateFlow<FilmModel> = _cached.asStateFlow()

    override suspend fun fetchFilms() {

        val response = service.fetchFilms()

        _cached.update { response.toFilmsModel() }

    }


}