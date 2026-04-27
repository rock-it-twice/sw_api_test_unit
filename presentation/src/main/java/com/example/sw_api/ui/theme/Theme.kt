package com.example.sw_api.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val appColorScheme = lightColorScheme(
    primary = DeepBlue,
    onPrimary = PureWhite,
    secondaryContainer = LightBlue,
    onSecondaryContainer = PureBlack,
    background = PureWhite,
    onBackground = PureBlack,
    surface = PureWhite,
    onSurface = PureBlack,
    outline = DarkGray
)

@Composable
fun Sw_apiTheme(
    darkTheme: Boolean = false,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = appColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}