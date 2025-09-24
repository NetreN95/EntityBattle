package ru.maxtere.entitybattle.ui.compose.views

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun StartGameButon(onClick: () -> Unit) {
    Button(
        onClick = onClick
    ) {
        Text(text = "Начать игру")
    }
}