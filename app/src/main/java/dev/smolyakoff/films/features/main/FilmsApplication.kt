package dev.smolyakoff.films.features.main

import android.app.Application
import dev.smolyakoff.films.core.di.networkModule
import dev.smolyakoff.films.features.films.di.filmsModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FilmsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FilmsApplication)
            modules(
                networkModule,
                filmsModules
            )
        }
    }

}