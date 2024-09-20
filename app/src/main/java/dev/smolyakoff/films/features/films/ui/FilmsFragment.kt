package dev.smolyakoff.films.features.films.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dev.smolyakoff.films.R
import dev.smolyakoff.films.core.ui.theme.FilmsTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmsFragment : Fragment() {


    private val filmsViewModel: FilmsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_films, container, false)
        val composeView = view.findViewById<ComposeView>(R.id.compose_view)

        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FilmsTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        FilmsView(
                            onFilmClick = { film ->
                                val action = FilmsFragmentDirections.navigateToFilmDetail(film)
                                findNavController().navigate(action)
                            },
                            viewModel = filmsViewModel,
                        )
                    }
                }
            }
        }

        return view
    }

}