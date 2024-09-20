package dev.smolyakoff.films.features.films.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.smolyakoff.films.core.ui.components.AsyncImage
import dev.smolyakoff.films.features.films.domain.Film

@Composable
fun FilmCard(
    modifier: Modifier = Modifier,
    model: Film,
    onClick: () -> Unit,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                onClick = onClick
            )
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(4.dp)),
            imageURL = model.imageURL,
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .align(Alignment.Start),
            text = model.localizedName,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 2
        )
    }
}