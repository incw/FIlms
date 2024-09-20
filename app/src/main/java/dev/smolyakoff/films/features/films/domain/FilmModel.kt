package dev.smolyakoff.films.features.films.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class FilmModel(
    val films: List<Film> = emptyList() ,
    val genres: List<String> = emptyList()
)


@Parcelize
data class Film(
    val id: Int = 0,
    val localizedName: String = "",
    val name: String = "",
    val year: String = "",
    val rating: Double? = null,
    val imageURL: String? = "",
    val description: String = "",
    val genres: List<String> = emptyList()
) : Parcelable