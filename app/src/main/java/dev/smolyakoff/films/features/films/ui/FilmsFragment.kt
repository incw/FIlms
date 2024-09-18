package dev.smolyakoff.films.features.films.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.findNavController
import dev.smolyakoff.films.R

class FilmsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_films, container, false)
        val composeView = view.findViewById<ComposeView>(R.id.compose_view)

        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    Surface (
                        modifier = Modifier.fillMaxSize()
                    ) {
                        FilmsView(
                            onFilmClick = {
                                findNavController().navigate(R.id.navigate_to_film_detail)
                            }
                        )
                    }
                }
            }
        }

        return view
    }

}