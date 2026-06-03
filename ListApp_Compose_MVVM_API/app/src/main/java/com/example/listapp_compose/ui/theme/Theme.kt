package com.example.listapp_compose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = GswGold,
    onPrimary = GswBlack,
    background = GswBlack,
    onBackground = Color.White,
    surface = GswGray,
    onSurface = Color.White
)

@Composable
fun ListApp_ComposeTheme(
    content: @Composable () -> Unit
){
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}