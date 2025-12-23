package com.beradeep.aiyo.ui

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.mikepenz.markdown.model.DefaultMarkdownTypography
import com.mikepenz.markdown.model.MarkdownTypography

@Composable
fun fontFamily() = FontFamily.Default

// Custom typography wrapper that extends Material 3 Typography
data class Typography(
    // Material 3 typography roles
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val displaySmall: TextStyle,
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,

    // Legacy support for existing code
    @Deprecated("Use headlineLarge instead", ReplaceWith("headlineLarge"))
    val h1: TextStyle = headlineLarge,
    @Deprecated("Use headlineMedium instead", ReplaceWith("headlineMedium"))
    val h2: TextStyle = headlineMedium,
    @Deprecated("Use headlineSmall instead", ReplaceWith("headlineSmall"))
    val h3: TextStyle = headlineSmall,
    @Deprecated("Use titleLarge instead", ReplaceWith("titleLarge"))
    val h4: TextStyle = titleLarge,
    @Deprecated("Use bodyLarge instead", ReplaceWith("bodyLarge"))
    val body1: TextStyle = bodyLarge,
    @Deprecated("Use bodyMedium instead", ReplaceWith("bodyMedium"))
    val body2: TextStyle = bodyMedium,
    @Deprecated("Use bodySmall instead", ReplaceWith("bodySmall"))
    val body3: TextStyle = bodySmall,
    @Deprecated("Use labelLarge instead", ReplaceWith("labelLarge"))
    val label1: TextStyle = labelLarge,
    @Deprecated("Use labelMedium instead", ReplaceWith("labelMedium"))
    val label2: TextStyle = labelMedium,
    @Deprecated("Use labelSmall instead", ReplaceWith("labelSmall"))
    val label3: TextStyle = labelSmall,
    @Deprecated("Use labelLarge instead", ReplaceWith("labelLarge"))
    val button: TextStyle = labelLarge,
    @Deprecated("Use bodyLarge instead", ReplaceWith("bodyLarge"))
    val input: TextStyle = bodyLarge
)

// Material Design 3 Typography defaults
private val defaultTypography =
    Typography(
        displayLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 57.sp,
            lineHeight = 64.sp,
            letterSpacing = (-0.25).sp
        ),
        displayMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 45.sp,
            lineHeight = 52.sp,
            letterSpacing = 0.sp
        ),
        displaySmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 36.sp,
            lineHeight = 44.sp,
            letterSpacing = 0.sp
        ),
        headlineLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.sp
        ),
        headlineMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 28.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp
        ),
        headlineSmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.sp
        ),
        titleLarge = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        titleMedium = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.1.sp
        ),
        titleSmall = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp
        ),
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        ),
        bodyMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp
        ),
        bodySmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.4.sp
        ),
        labelLarge = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp
        ),
        labelMedium = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        ),
        labelSmall = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
    )

@Composable
fun provideTypography(): Typography {
    val fontFamily = fontFamily()

    return defaultTypography.copy(
        displayLarge = defaultTypography.displayLarge.copy(fontFamily = fontFamily),
        displayMedium = defaultTypography.displayMedium.copy(fontFamily = fontFamily),
        displaySmall = defaultTypography.displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = defaultTypography.titleLarge.copy(fontFamily = fontFamily),
        titleMedium = defaultTypography.titleMedium.copy(fontFamily = fontFamily),
        titleSmall = defaultTypography.titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = defaultTypography.bodySmall.copy(fontFamily = fontFamily),
        labelLarge = defaultTypography.labelLarge.copy(fontFamily = fontFamily),
        labelMedium = defaultTypography.labelMedium.copy(fontFamily = fontFamily),
        labelSmall = defaultTypography.labelSmall.copy(fontFamily = fontFamily)
    )
}

val LocalTypography = staticCompositionLocalOf { defaultTypography }
val LocalTextStyle = compositionLocalOf(structuralEqualityPolicy()) { TextStyle.Default }

// Material 3 Typography support
fun material3Typography(): androidx.compose.material3.Typography {
    val fontFamily = FontFamily.Default

    return androidx.compose.material3.Typography(
        displayLarge = defaultTypography.displayLarge.copy(fontFamily = fontFamily),
        displayMedium = defaultTypography.displayMedium.copy(fontFamily = fontFamily),
        displaySmall = defaultTypography.displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = defaultTypography.titleLarge.copy(fontFamily = fontFamily),
        titleMedium = defaultTypography.titleMedium.copy(fontFamily = fontFamily),
        titleSmall = defaultTypography.titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = defaultTypography.bodySmall.copy(fontFamily = fontFamily),
        labelLarge = defaultTypography.labelLarge.copy(fontFamily = fontFamily),
        labelMedium = defaultTypography.labelMedium.copy(fontFamily = fontFamily),
        labelSmall = defaultTypography.labelSmall.copy(fontFamily = fontFamily)
    )
}

@Composable
fun markdownTypography(
    h1: TextStyle = provideTypography().headlineLarge,
    h2: TextStyle = provideTypography().headlineMedium,
    h3: TextStyle = provideTypography().headlineSmall,
    h4: TextStyle = provideTypography().titleLarge,
    h5: TextStyle = provideTypography().titleMedium,
    h6: TextStyle = provideTypography().titleSmall,
    text: TextStyle = provideTypography().bodyLarge,
    code: TextStyle = provideTypography().bodyMedium.copy(fontFamily = FontFamily.Monospace),
    inlineCode: TextStyle = text.copy(fontFamily = FontFamily.Monospace),
    quote: TextStyle = provideTypography().bodyLarge.plus(SpanStyle(fontStyle = FontStyle.Italic)),
    paragraph: TextStyle = provideTypography().bodyLarge,
    ordered: TextStyle = provideTypography().bodyLarge,
    bullet: TextStyle = provideTypography().bodyLarge,
    list: TextStyle = provideTypography().bodyLarge,
    textLink: TextLinkStyles =
        TextLinkStyles(
            style =
            provideTypography()
                .bodySmall
                .copy(
                    color = LocalColorScheme.current.tertiary,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                ).toSpanStyle()
        ),
    table: TextStyle = text
): MarkdownTypography = DefaultMarkdownTypography(
    h1 = h1,
    h2 = h2,
    h3 = h3,
    h4 = h4,
    h5 = h5,
    h6 = h6,
    text = text,
    quote = quote,
    code = code,
    inlineCode = inlineCode,
    paragraph = paragraph,
    ordered = ordered,
    bullet = bullet,
    list = list,
    textLink = textLink,
    table = table
)
