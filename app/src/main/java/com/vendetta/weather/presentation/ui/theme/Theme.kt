package com.vendetta.weather.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = backgroundDark,
    onBackground = mainTextDark,
    secondary = secondaryText,
    onPrimary = selectedDay,
    onSecondary = unselectedDay
)

private val LightColorScheme = lightColorScheme(
    background = backgroundLight,
    onBackground = mainTextLight,
    secondary = secondaryText,
    onPrimary = selectedDay,
    onSecondary = unselectedDay
)

@Composable
fun WeatherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}