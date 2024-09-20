package dev.smolyakoff.films.core.network

import retrofit2.converter.gson.GsonConverterFactory

fun provideGson(): GsonConverterFactory =
    GsonConverterFactory.create()