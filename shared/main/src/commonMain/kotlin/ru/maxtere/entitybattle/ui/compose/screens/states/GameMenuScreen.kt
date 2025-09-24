package ru.maxtere.entitybattle.ui.compose.screens.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.maxtere.entitybattle.game.GameState
import ru.maxtere.entitybattle.ui.compose.views.StartGameButon

@Composable
fun GameMenuScreen(state: GameState.GameMenu) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StartGameButon(onClick = state.startGame)
    }
}