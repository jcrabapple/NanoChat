package com.beradeep.aiyo.ui.basics.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    variant: IconButtonVariant = IconButtonVariant.PrimaryGhost,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    // Currently only PrimaryGhost is defined, which corresponds to the standard IconButton
    androidx.compose.material3.IconButton(
        onClick = onClick,
        modifier = modifier.clip(shape),
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource,
        content = content
    )
}

enum class IconButtonVariant {
    PrimaryGhost
}
