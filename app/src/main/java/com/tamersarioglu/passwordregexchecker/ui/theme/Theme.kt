package com.tamersarioglu.passwordregexchecker.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = Color.Black,
    secondary = Color(0xFF1E3932),
    tertiary = Color(0xFF00704A), // Starbucks green
    background = Color.White,
    surface = Color.White,
    onBackground = Color(0xFF4D4D4D), // Dark gray for text
    onSurface = Color(0xFF4D4D4D),
    error = Color(0xFFB00020),
    onError = Color.White,
    outline = Color(0xFFE0E0E0)
)

private val LightColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = Color.Black,
    secondary = Color(0xFF1E3932),
    tertiary = Color(0xFF00704A), // Starbucks green
    background = Color.White,
    surface = Color.White,
    onBackground = Color(0xFF4D4D4D), // Dark gray for text
    onSurface = Color(0xFF4D4D4D),
    error = Color(0xFFB00020),
    onError = Color.White,
    outline = Color(0xFFE0E0E0)
)

@Composable
fun PasswordRegexCheckerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}