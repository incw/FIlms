package dev.smolyakoff.films.core.ui.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

val Placeholder: ImageVector
    get() {
        if (_Placeholder != null) {
            return _Placeholder!!
        }
        _Placeholder = ImageVector.Builder(
            name = "Placeholder",
            defaultWidth = 160.dp,
            defaultHeight = 222.dp,
            viewportWidth = 160f,
            viewportHeight = 222f
        ).apply {
            path(fill = SolidColor(Color(0xFFEFEFEF))) {
                moveTo(4f, 0f)
                lineTo(156f, 0f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 160f, 4f)
                lineTo(160f, 218f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 156f, 222f)
                lineTo(4f, 222f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 218f)
                lineTo(0f, 4f)
                arcTo(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 0f)
                close()
            }
            group {
                path(fill = SolidColor(Color(0xFFCBCBCB))) {
                    moveTo(56.07f, 95.46f)
                    horizontalLineTo(51.28f)
                    verticalLineTo(108.41f)
                    horizontalLineTo(51.31f)
                    lineTo(51.28f, 131.72f)
                    curveTo(51.28f, 134.57f, 53.44f, 136.9f, 56.07f, 136.9f)
                    horizontalLineTo(99.15f)
                    verticalLineTo(131.72f)
                    horizontalLineTo(56.07f)
                    verticalLineTo(95.46f)
                    close()
                    moveTo(103.93f, 90.28f)
                    horizontalLineTo(84.79f)
                    lineTo(80f, 85.1f)
                    horizontalLineTo(65.64f)
                    curveTo(63.01f, 85.1f, 60.88f, 87.43f, 60.88f, 90.28f)
                    lineTo(60.85f, 121.36f)
                    curveTo(60.85f, 124.21f, 63.01f, 126.54f, 65.64f, 126.54f)
                    horizontalLineTo(103.93f)
                    curveTo(106.56f, 126.54f, 108.72f, 124.21f, 108.72f, 121.36f)
                    verticalLineTo(95.46f)
                    curveTo(108.72f, 92.61f, 106.56f, 90.28f, 103.93f, 90.28f)
                    close()
                    moveTo(68.03f, 118.77f)
                    lineTo(78.8f, 103.23f)
                    lineTo(87.18f, 114.91f)
                    lineTo(93.16f, 107.11f)
                    lineTo(101.54f, 118.77f)
                    horizontalLineTo(68.03f)
                    close()
                }
            }
        }.build()

        return _Placeholder!!
    }

@Suppress("ObjectPropertyName")
private var _Placeholder: ImageVector? = null
