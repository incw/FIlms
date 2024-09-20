package dev.smolyakoff.films.features.film_detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import dev.smolyakoff.films.R
import dev.smolyakoff.films.core.ui.components.AsyncImage
import dev.smolyakoff.films.core.ui.components.BaseTopAppBar
import dev.smolyakoff.films.features.films.domain.Film

@Composable
fun FilmDetailView(
    modifier: Modifier = Modifier,
    model: Film,
    onBackClick: () -> Unit
) {

    val configuration = LocalConfiguration.current

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier,
        topBar = {
            BaseTopAppBar(
                title = model.name,
                navigationIcon = {
                    IconButton(
                        onClick = { onBackClick() }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = stringResource(id = R.string.navigate_back)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            AsyncImage(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width((configuration.screenWidthDp / 2).dp)
                    .height((configuration.screenHeightDp / 3).dp)
                    .clip(RoundedCornerShape(4.dp)),
                imageURL = model.imageURL,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = model.localizedName,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = buildAnnotatedString {
                    if (model.genres.isNotEmpty()) {
                        append("${model.genres.joinToString(", ")}, ")
                    }
                    append("${model.year} год")
                },
                color = MaterialTheme.colorScheme.surfaceVariant,
                style = MaterialTheme.typography.titleMedium
            )

            model.rating?.let {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "${model.rating}",
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.displayMedium
                    )
                    Text(
                        text = "КиноПоиск",
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            }



            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = model.description,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}