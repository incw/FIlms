package dev.smolyakoff.films.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel : ViewModel() {

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    protected fun String.asError() = _error.tryEmit(this)

    fun clearError() = _error.tryEmit(null)

}