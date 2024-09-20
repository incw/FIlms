package dev.smolyakoff.films.core.extensions

import kotlinx.coroutines.flow.MutableStateFlow

fun MutableStateFlow<Boolean>.toggle() {
    this.tryEmit(!value)
}