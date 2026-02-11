package com.example.nextreptfc.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// MODO OSCURO (DARK MODE)
private val DarkColorScheme = darkColorScheme(
    primary = OrangePrimary,
    onPrimary = DarkTextPrimary,

    background = DarkBackground,
    onBackground = DarkTextPrimary,

    surface = DarkSurface,
    onSurface = DarkTextPrimary,

    surfaceVariant = DarkInput,
    onSurfaceVariant = DarkTextSecondary,

    error = RedError
)

// MODO CLARO (LIGHT MODE)
private val LightColorScheme = lightColorScheme(
    primary = OrangePrimary,
    onPrimary = LightTextPrimary,

    background = LightBackground,
    onBackground = LightTextPrimary,

    surface = LightSurface,
    onSurface = LightTextPrimary,

    surfaceVariant = LightInput,
    onSurfaceVariant = LightTextSecondary,

    error = RedError
)

@Composable
fun NextRepTFCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+

    /*
        Lo que hace dynamicColor es crear una paleta de colores basandose en el
        fondo de pantalla del usuario. Por eso hay que desactivarlo, ya que no queremos
        que haga eso
     */
    dynamicColor: Boolean = false,
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