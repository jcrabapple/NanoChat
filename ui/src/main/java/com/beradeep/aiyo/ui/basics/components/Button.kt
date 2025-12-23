package com.beradeep.aiyo.ui.basics.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.beradeep.aiyo.ui.LocalColorScheme

// Material Design 3 Button Component
@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String? = null,
    enabled: Boolean = true,
    loading: Boolean = false,
    variant: ButtonVariant = ButtonVariant.Primary,
    onClick: () -> Unit = {},
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: (@Composable () -> Unit)? = null
) {
    when (variant) {
        ButtonVariant.Primary -> {
            Button(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        ButtonVariant.PrimaryElevated -> {
            ElevatedButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        ButtonVariant.PrimaryOutlined -> {
            OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        ButtonVariant.Secondary -> {
            FilledTonalButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        ButtonVariant.SecondaryElevated -> {
            ElevatedButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        ButtonVariant.SecondaryOutlined -> {
            OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        ButtonVariant.Destructive -> {
            Button(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        ButtonVariant.DestructiveElevated -> {
            ElevatedButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        ButtonVariant.DestructiveOutlined -> {
            OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
        else -> {
            TextButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled && !loading,
                colors = buttonColors(variant),
                elevation = buttonElevation(variant),
                shape = buttonShape(variant),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                ButtonContent(text, content)
            }
        }
    }
}

@Composable
private fun ButtonContent(
    text: String?,
    content: (@Composable () -> Unit)?
) {
    if (!text.isNullOrEmpty()) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Clip,
            maxLines = 1
        )
    } else {
        content?.invoke()
    }
}

@Composable
private fun buttonColors(variant: ButtonVariant): ButtonColors {
    val colorScheme = LocalColorScheme.current
    return when (variant) {
        ButtonVariant.Primary -> ButtonDefaults.buttonColors()
        ButtonVariant.PrimaryElevated -> ButtonDefaults.elevatedButtonColors()
        ButtonVariant.PrimaryOutlined -> ButtonDefaults.outlinedButtonColors()
        ButtonVariant.Secondary -> ButtonDefaults.filledTonalButtonColors()
        ButtonVariant.SecondaryElevated -> ButtonDefaults.elevatedButtonColors(
            containerColor = colorScheme.secondaryContainer,
            contentColor = colorScheme.onSecondaryContainer
        )
        ButtonVariant.SecondaryOutlined -> ButtonDefaults.outlinedButtonColors(
            containerColor = colorScheme.secondaryContainer,
            contentColor = colorScheme.onSecondaryContainer
        )
        ButtonVariant.Destructive -> ButtonDefaults.buttonColors(
            containerColor = colorScheme.error,
            contentColor = colorScheme.onError
        )
        ButtonVariant.DestructiveElevated -> ButtonDefaults.elevatedButtonColors(
            containerColor = colorScheme.error,
            contentColor = colorScheme.onError
        )
        ButtonVariant.DestructiveOutlined -> ButtonDefaults.outlinedButtonColors(
            containerColor = colorScheme.errorContainer,
            contentColor = colorScheme.onError
        )
        else -> ButtonDefaults.textButtonColors()
    }
}

@Composable
private fun buttonElevation(variant: ButtonVariant): ButtonElevation? {
    return when (variant) {
        ButtonVariant.PrimaryElevated,
        ButtonVariant.SecondaryElevated,
        ButtonVariant.DestructiveElevated -> ButtonDefaults.elevatedButtonElevation()
        else -> null
    }
}

@Composable
private fun buttonShape(variant: ButtonVariant) = com.beradeep.aiyo.ui.shapes().medium

// Updated ButtonVariant enum to match Material 3
enum class ButtonVariant {
    Primary,
    PrimaryElevated,
    PrimaryOutlined,
    PrimaryGhost,
    Secondary,
    SecondaryElevated,
    SecondaryOutlined,
    SecondaryGhost,
    Destructive,
    DestructiveElevated,
    DestructiveOutlined,
    DestructiveGhost,
    Ghost
}