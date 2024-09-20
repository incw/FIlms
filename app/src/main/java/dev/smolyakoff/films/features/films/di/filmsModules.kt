package dev.smolyakoff.films.features.films.di

import dev.smolyakoff.films.features.films.data.FilmsRepositoryImpl
import dev.smolyakoff.films.features.films.domain.FilmsRepository
import dev.smolyakoff.films.features.films.ui.FilmsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val filmsModules = module {
    single<FilmsRepository> { FilmsRepositoryImpl(get()) }
    viewModelOf(::FilmsViewModel)
}