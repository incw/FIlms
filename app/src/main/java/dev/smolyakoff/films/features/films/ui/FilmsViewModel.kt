package dev.smolyakoff.films.features.films.ui

import androidx.lifecycle.viewModelScope
import dev.smolyakoff.films.core.BaseViewModel
import dev.smolyakoff.films.core.extensions.runSuspendCatching
import dev.smolyakoff.films.core.extensions.toggle
import dev.smolyakoff.films.features.films.domain.FilmsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

typealias FilmGenre = String

class FilmsViewModel(
    private val repository: FilmsRepository
) : BaseViewModel() {


    private companion object {
        private const val DEFAULT_ERROR_DESC = "Ошибка подключения сети"
    }

    private val _selectedCategory = MutableStateFlow<FilmGenre?>(null)
    val selectedCategory = _selectedCategory.asStateFlow()


    private val cachedFilmsFlow = repository.cached


    fun retry() {
        /**
         * Provide retry event
         */
        clearError()
    }


    val viewState: StateFlow<FilmsViewState> = combine(
        cachedFilmsFlow,
        selectedCategory,
    ) { model, category ->

        val filteredFilms = category?.let { cat ->
            model.films.filter { film ->
                film.genres.any { it.equals(cat, ignoreCase = true) }
            }
        } ?: model.films

        val sortedList = filteredFilms.sortedBy { it.localizedName }

        FilmsViewState.Success(films = sortedList, genres = model.genres)
    }
        .onStart { repository.fetchFilms() }
        .filter { it.films.isNotEmpty() }
        .catch {
            DEFAULT_ERROR_DESC.asError()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            initialValue = FilmsViewState.Loading
        )


    fun selectCategory(category: FilmGenre) {
        if (category == selectedCategory.value) {
            _selectedCategory.tryEmit(null)
        } else {
            _selectedCategory.tryEmit(category)
        }
    }


}