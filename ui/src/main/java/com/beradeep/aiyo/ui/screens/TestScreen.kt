package com.beradeep.aiyo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beradeep.aiyo.ui.AiyoTheme
import com.beradeep.aiyo.ui.basics.components.Button
import com.beradeep.aiyo.ui.basics.components.Text

@Composable
fun TestScreen() {
    AiyoTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Material Design 3 Test",
                    style = MaterialTheme.typography.headlineMedium
                )
                Button(
                    text = "Test Button",
                    onClick = { }
                )
            }
        }
    }
}