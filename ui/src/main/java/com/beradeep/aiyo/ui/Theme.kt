package com.beradeep.aiyo.ui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.beradeep.aiyo.ui.basics.foundation.ripple

object AiyoTheme {
    val colorScheme: ColorScheme
        @ReadOnlyComposable @Composable
        get() = LocalColorScheme.current

    val typography: androidx.compose.material3.Typography
        @Composable
        get() = material3Typography()

    // Legacy support
    @Deprecated("Use colorScheme instead", ReplaceWith("colorScheme"))
    val colors: ColorScheme
        @ReadOnlyComposable @Composable
        get() = colorScheme
}

@Composable
fun AiyoTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    useDynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val rippleIndication = ripple()
    val typography = provideTypography()

    // Choose color scheme
    val colorScheme = if (useDynamicColor) {
        dynamicColorScheme() ?: if (isDarkTheme) DarkColorScheme else LightColorScheme
    } else {
        if (isDarkTheme) DarkColorScheme else LightColorScheme
    }

    val selectionColors = rememberTextSelectionColors(colorScheme)

    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalTypography provides provideTypography(),
        LocalShapes provides shapes(),
        LocalIndication provides rippleIndication,
        LocalTextSelectionColors provides selectionColors,
        LocalContentColor provides colorScheme.contentColorFor(colorScheme.background),
        LocalTextStyle provides provideTypography().bodyLarge
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = material3Typography(),
            shapes = shapes(),
            content = content
        )
    }
}

@Composable
fun contentColorFor(color: Color): Color = MaterialTheme.colorScheme.contentColorFor(color)

@Composable
internal fun rememberTextSelectionColors(colorScheme: ColorScheme): TextSelectionColors {
    val primaryColor = colorScheme.primary
    return remember(primaryColor) {
        TextSelectionColors(
            handleColor = primaryColor,
            backgroundColor = primaryColor.copy(alpha = TextSelectionBackgroundOpacity)
        )
    }
}

internal const val TextSelectionBackgroundOpacity = 0.4f
