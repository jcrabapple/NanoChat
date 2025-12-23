package com.beradeep.aiyo.ui

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.mikepenz.markdown.model.DefaultMarkdownColors
import com.mikepenz.markdown.model.MarkdownColors

val Black: Color = Color(0xFF000000)
val Gray900: Color = Color(0xFF282828)
val Gray800: Color = Color(0xFF4b4b4b)
val Gray700: Color = Color(0xFF5e5e5e)
val Gray600: Color = Color(0xFF727272)
val Gray500: Color = Color(0xFF868686)
val Gray400: Color = Color(0xFFC7C7C7)
val Gray300: Color = Color(0xFFDFDFDF)
val Gray200: Color = Color(0xFFE2E2E2)
val Gray100: Color = Color(0xFFF7F7F7)
val Gray50: Color = Color(0xFFFFFFFF)
val White: Color = Color(0xFFFFFFFF)

val Red900: Color = Color(0xFF520810)
val Red800: Color = Color(0xFF950f22)
val Red700: Color = Color(0xFFbb032a)
val Red600: Color = Color(0xFFde1135)
val Red500: Color = Color(0xFFf83446)
val Red400: Color = Color(0xFFfc7f79)
val Red300: Color = Color(0xFFffb2ab)
val Red200: Color = Color(0xFFffd2cd)
val Red100: Color = Color(0xFFffe1de)
val Red50: Color = Color(0xFFfff0ee)

val Blue900: Color = Color(0xFF276EF1)
val Blue800: Color = Color(0xFF3F7EF2)
val Blue700: Color = Color(0xFF578EF4)
val Blue600: Color = Color(0xFF6F9EF5)
val Blue500: Color = Color(0xFF87AEF7)
val Blue400: Color = Color(0xFF9FBFF8)
val Blue300: Color = Color(0xFFB7CEFA)
val Blue200: Color = Color(0xFFCFDEFB)
val Blue100: Color = Color(0xFFE7EEFD)
val Blue50: Color = Color(0xFFFFFFFF)

val Green950: Color = Color(0xFF0B4627)
val Green900: Color = Color(0xFF16643B)
val Green800: Color = Color(0xFF1A7544)
val Green700: Color = Color(0xFF178C4E)
val Green600: Color = Color(0xFF1DAF61)
val Green500: Color = Color(0xFF1FC16B)
val Green400: Color = Color(0xFF3EE089)
val Green300: Color = Color(0xFF84EBB4)
val Green200: Color = Color(0xFFC2F5DA)
val Green100: Color = Color(0xFFD0FBE9)
val Green50: Color = Color(0xFFE0FAEC)

// Material Design 3 Light Color Scheme
internal val LightColorScheme: ColorScheme = lightColorScheme(
    primary = Black,
    onPrimary = White,
    primaryContainer = Gray200,
    onPrimaryContainer = Black,
    secondary = Gray400,
    onSecondary = Black,
    secondaryContainer = Gray300,
    onSecondaryContainer = Gray800,
    tertiary = Blue900,
    onTertiary = White,
    tertiaryContainer = Blue100,
    onTertiaryContainer = Blue900,
    error = Red600,
    onError = White,
    errorContainer = Red100,
    onErrorContainer = Red900,
    background = White,
    onBackground = Black,
    surface = Gray200,
    onSurface = Black,
    surfaceVariant = Gray100,
    onSurfaceVariant = Gray700,
    outline = Gray300,
    outlineVariant = Gray200,
    scrim = Color.Black.copy(alpha = 0.32f),
    surfaceTint = Black,
    inverseSurface = Gray900,
    inverseOnSurface = White,
    inversePrimary = White
)

// Material Design 3 Dark Color Scheme
internal val DarkColorScheme: ColorScheme = darkColorScheme(
    primary = White,
    onPrimary = Black,
    primaryContainer = Gray800,
    onPrimaryContainer = White,
    secondary = Gray400,
    onSecondary = White,
    secondaryContainer = Gray600,
    onSecondaryContainer = Gray200,
    tertiary = Blue300,
    onTertiary = Black,
    tertiaryContainer = Blue900,
    onTertiaryContainer = Blue300,
    error = Red400,
    onError = Black,
    errorContainer = Red900,
    onErrorContainer = Red200,
    background = Black,
    onBackground = White,
    surface = Gray900,
    onSurface = White,
    surfaceVariant = Gray800,
    onSurfaceVariant = Gray300,
    outline = Gray800,
    outlineVariant = Gray700,
    scrim = Color.Black.copy(alpha = 0.72f),
    surfaceTint = White,
    inverseSurface = Gray100,
    inverseOnSurface = Black,
    inversePrimary = Black
)

// Dynamic color support for Android 12+
@Composable
fun dynamicColorScheme(): ColorScheme? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        if (isSystemInDarkTheme()) {
            dynamicDarkColorScheme(context)
        } else {
            dynamicLightColorScheme(context)
        }
    } else {
        null
    }
}

val LocalColorScheme = staticCompositionLocalOf { LightColorScheme }
val LocalContentColor = compositionLocalOf { Color.Black }
val LocalContentAlpha = compositionLocalOf { 1f }

// Legacy support for existing code
@Deprecated("Use MaterialTheme.colorScheme instead", ReplaceWith("MaterialTheme.colorScheme"))
val Colors: ColorScheme
    @Composable get() = LocalColorScheme.current

@Composable
fun markdownColor(
    text: Color = LocalColorScheme.current.onBackground,
    codeBackground: Color = LocalColorScheme.current.onBackground.copy(alpha = 0.1f),
    inlineCodeBackground: Color = codeBackground,
    dividerColor: Color = LocalColorScheme.current.onSurface.copy(alpha = 0.12f),
    tableBackground: Color = LocalColorScheme.current.surfaceVariant.copy(alpha = 0.5f)
): MarkdownColors = DefaultMarkdownColors(
    text = text,
    codeBackground = codeBackground,
    inlineCodeBackground = inlineCodeBackground,
    dividerColor = dividerColor,
    tableBackground = tableBackground
)
