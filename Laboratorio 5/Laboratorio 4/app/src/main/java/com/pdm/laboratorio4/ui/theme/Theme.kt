package com.pdm.laboratorio4.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = RosaOscuro,
    secondary = MoradoOscuro,
    tertiary = CelesteOscuro
)

private val LightColorScheme = lightColorScheme(
    primary = RosaPastel,
    secondary = MoradoPastel,
    tertiary = CelestePastel
)

@Composable
fun Laboratorio4Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}