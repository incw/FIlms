package dev.smolyakoff.films.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


val Typography = Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight(700),
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.1.sp
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight(500),
        fontSize = 18.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Center
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight(700),
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    displayLarge = TextStyle(
        fontWeight = FontWeight(700),
        fontSize = 26.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.1.sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight(700),
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.1.sp
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight(500),
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.1.sp
    )
)