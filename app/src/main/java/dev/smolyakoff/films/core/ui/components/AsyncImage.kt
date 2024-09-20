package dev.smolyakoff.films.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import dev.smolyakoff.films.R

/**
default component for load image
 */

@Composable
fun AsyncImage(
    modifier: Modifier,
    imageURL: String?,
    contentScale: ContentScale = ContentScale.FillWidth
) {

    val context = LocalContext.current

    SubcomposeAsyncImage(
        modifier = modifier,
        model = ImageRequest
            .Builder(context)
            .data(imageURL)
            .crossfade(true)
            .build(),
        contentScale = contentScale,
        contentDescription = stringResource(id = R.string.image),
        error = {
            Image(
                imageVector = Placeholder,
                contentDescription = "image error",
                modifier = modifier,
                contentScale = contentScale
            )
        },
        loading = {
            Image(
                imageVector = Placeholder,
                contentDescription = "image error",
                modifier = modifier,
                contentScale = contentScale
            )
        }
    )
}