package dev.smolyakoff.films.features.film_detail.ui

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
import androidx.navigation.fragment.navArgs
import dev.smolyakoff.films.R
import dev.smolyakoff.films.core.ui.theme.FilmsTheme

class FilmDetailFragment : Fragment() {

    private val args: FilmDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_film_detail, container, false)
        val composeView = view.findViewById<ComposeView>(R.id.compose_view)

        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FilmsTheme {
                    Surface (
                        modifier = Modifier.fillMaxSize()
                    ) {
                        FilmDetailView(
                            onBackClick = {
                                findNavController().popBackStack()
                            },
                            model = args.film
                        )
                    }

                }
            }
        }
        return view
    }
}