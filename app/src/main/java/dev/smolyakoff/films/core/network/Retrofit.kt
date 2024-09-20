package dev.smolyakoff.films.core.network

import dev.smolyakoff.films.features.films.api.FilmsService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(
    client: OkHttpClient,
    gson: GsonConverterFactory
): Retrofit =
    Retrofit
        .Builder()
        .baseUrl("https://s3-eu-west-1.amazonaws.com/")
        .client(client)
        .addConverterFactory(gson)
        .build()

fun provideFilmsService(retrofit: Retrofit): FilmsService =
    retrofit.create(FilmsService::class.java)