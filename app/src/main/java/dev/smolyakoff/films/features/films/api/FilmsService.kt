package dev.smolyakoff.films.features.films.api

import dev.smolyakoff.films.features.films.data.FilmsResponse
import retrofit2.http.GET

interface FilmsService {

    @GET("sequeniatesttask/films.json")
    suspend fun fetchFilms(): FilmsResponse

}