package dev.smolyakoff.films.core.di

import dev.smolyakoff.films.core.network.provideFilmsService
import dev.smolyakoff.films.core.network.provideGson
import dev.smolyakoff.films.core.network.provideOkHttpClient
import dev.smolyakoff.films.core.network.provideRetrofit
import org.koin.dsl.module


val networkModule = module {
    single { provideOkHttpClient() }
    single { provideGson() }
    single { provideRetrofit(get(), get()) }
    single { provideFilmsService(get()) }
}