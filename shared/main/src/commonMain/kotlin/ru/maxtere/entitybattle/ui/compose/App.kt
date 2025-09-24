package ru.maxtere.entitybattle.ui.compose

import androidx.compose.runtime.Composable
import ru.maxtere.entitybattle.game.Game
import ru.maxtere.entitybattle.ui.compose.screens.GameScreen
import ru.maxtere.sdk.di.koin.getKoinInstance

@Composable
fun App() {
    val game = getKoinInstance<Game>()
    GameScreen(game = game)
}