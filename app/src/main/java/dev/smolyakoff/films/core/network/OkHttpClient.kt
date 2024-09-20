package dev.smolyakoff.films.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


fun provideOkHttpClient() =
    OkHttpClient
        .Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .connectTimeout(7, TimeUnit.SECONDS)
        .readTimeout(7, TimeUnit.SECONDS)
        .build()