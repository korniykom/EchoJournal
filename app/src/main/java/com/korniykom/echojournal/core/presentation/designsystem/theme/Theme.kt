package com.korniykom.echojournal.core.presentation.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Primary30,
    primaryContainer = Primary50,
    onPrimaryContainer = Color(0xFFEEF0FF),
    onPrimary = Primary100,
    inversePrimary = Secondary80,
    secondary = Secondary30,
    secondaryContainer = Secondary50,
    background = NeutralVariant99,
    surface = Primary100,
    surfaceVariant = Color(0xFFE1E2EC),
    onSurface = NeutralVariant10,
    onSurfaceVariant = NeutralVariant30,
    outline = NeutralVariant50,
    outlineVariant = NeutralVariant80,
    errorContainer = Error95,
    onErrorContainer = Error20,
    onError = Error100
)

private val LightColorScheme = lightColorScheme(
    primary = Primary30,
    primaryContainer = Primary50,
    onPrimaryContainer = Color(0xFFEEF0FF),
    onPrimary = Primary100,
    inversePrimary = Secondary80,
    secondary = Secondary30,
    secondaryContainer = Secondary50,
    background = NeutralVariant99,
    surface = Primary100,
    surfaceVariant = Color(0xFFE1E2EC),
    onSurface = NeutralVariant10,
    onSurfaceVariant = NeutralVariant30,
    outline = NeutralVariant50,
    outlineVariant = NeutralVariant80,
    errorContainer = Error95,
    onErrorContainer = Error20,
    onError = Error100
)


@Composable
fun EchoJournalTheme(
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