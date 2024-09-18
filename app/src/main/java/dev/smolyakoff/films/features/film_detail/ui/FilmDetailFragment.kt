package dev.smolyakoff.films.features.film_detail.ui

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

class FilmDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_film_detail, container, false)
        val composeView = view.findViewById<ComposeView>(R.id.compose_view)

        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    Surface (
                        modifier = Modifier.fillMaxSize()
                    ) {
                        FilmDetailView(
                            onBackClick = {
                                findNavController().popBackStack()
                            }
                        )
                    }

                }
            }
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FilmDetailFragment().apply {
                arguments = Bundle().apply {
                    /**
                     * Put String(args*)
                     */
                }
            }
    }
}