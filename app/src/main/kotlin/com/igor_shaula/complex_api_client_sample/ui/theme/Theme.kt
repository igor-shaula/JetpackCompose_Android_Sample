package com.igor_shaula.complex_api_client_sample.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
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

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)

//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//)

private val GivenColorScheme = lightColorScheme(
    primary = DarkGreen,
    onPrimary = Color.DarkGray,
    secondary = Color.White,
    onSecondary = Color.DarkGray,
    tertiary = Color.White,
    onTertiary = Color.DarkGray,
    background = Color.White,
    onBackground = Color.DarkGray,
    surface = Green,
    onSurface = Color.DarkGray,
    surfaceTint = Color.White,
    surfaceVariant = Color.White,
    onSurfaceVariant = Color.DarkGray,
    inverseSurface = Color.White,
    inverseOnSurface = Color.DarkGray,
    onPrimaryContainer = Color.DarkGray,
    onSecondaryContainer = Color.DarkGray,
    onTertiaryContainer = Color.DarkGray,
    primaryContainer = Color.White,
    secondaryContainer = Color.White,
    tertiaryContainer = Color.White,
    inversePrimary = Color.White,
    outline = Color.Cyan,
    outlineVariant = Color.Blue,
    scrim = Color.Red
)

@Composable
fun TheAppTheme(
    darkTheme: Boolean = false, // because in the task's preview there is only one screen - in LIGHT THEME
//    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
        else -> GivenColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}