package ru.maxtere.entitybattle.ui.compose.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ru.maxtere.entitybattle.game.Game
import ru.maxtere.entitybattle.game.GameState
import ru.maxtere.entitybattle.game.GameState.GameMenu
import ru.maxtere.entitybattle.game.GameState.GameOver
import ru.maxtere.entitybattle.game.GameState.GameTurn
import ru.maxtere.entitybattle.ui.compose.screens.states.GameMenuScreen
import ru.maxtere.entitybattle.ui.compose.screens.states.GameOverScreen
import ru.maxtere.entitybattle.ui.compose.screens.states.GameTurnScreen

@Composable
fun GameScreen(game: Game) {
    val state = game.state.collectAsState()
    GameScreen(state = state.value)
}

@Composable
fun GameScreen(state: GameState) {
    when (state) {
        is GameMenu -> GameMenuScreen(state = state)
        is GameTurn -> GameTurnScreen(state = state)
        is GameOver -> GameOverScreen(state = state)
    }
}