package ru.maxtere.entitybattle.ui.compose.screens.states

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ru.maxtere.entitybattle.game.GameState

@Composable
fun GameOverScreen(state: GameState.GameOver) {
    Text(text = "Game over")
}