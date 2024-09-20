package dev.smolyakoff.films.features.films.data

import dev.smolyakoff.films.features.films.domain.Film
import dev.smolyakoff.films.features.films.domain.FilmModel
import kotlin.math.ceil
import kotlin.math.roundToInt

private fun FilmDTO.toModel() =
    Film(
        id = id,
        localizedName = localizedName,
        name = name,
        year = year.toString(),
        rating = this.rating?.let { ceil(it * 10) / 10 },
        description = description ?: "",
        genres = genres,
        imageURL = this.imageUrl
    )

internal fun FilmsResponse.toFilmsModel() =
    FilmModel(
        films = this.films.map { it.toModel() },
        genres = sortGenres(this.films)
    )


internal fun sortGenres(films: List<FilmDTO>): List<String> {

    val genreSet = mutableSetOf<String>()


    films.forEach { film ->
        film.genres.forEach { genre ->
            genreSet.add(genre.lowercase())
        }
    }


    return genreSet
        .map { it.capitalize() }
        .sorted()
}