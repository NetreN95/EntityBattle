package ru.maxtere.entitybattle.game

import ru.maxtere.entitybattle.entities.Monster
import ru.maxtere.entitybattle.entities.Player
import ru.maxtere.entitybattle.entities.entity.Entity
import ru.maxtere.entitybattle.game.extensions.nextAliveEntityIndex
import ru.maxtere.entitybattle.game.extensions.onStartTurn

sealed class GameState() {

    class GameMenu(
        val startGame: () -> Unit
    ) : GameState()

    data class GameTurn(
        val entities: List<Entity> = listOf(),
        private var _currentEntityIndex: Int = 0,
        val gameOver: (entities: List<Entity>) -> Unit,
        val update: () -> Unit
    ) : GameState() {
        val currentEntityIndex get() = _currentEntityIndex

        fun nextTurn() {
            val newIndex = nextAliveEntityIndex()
            if (newIndex == null) {
                gameOver(entities)
                return
            }
            _currentEntityIndex = newIndex
            onStartTurn()
        }
    }

    class GameOver(
        val entities: List<Entity> = listOf()
    ) : GameState()


    companion object {
        fun newGame(
            gameOver: (entities: List<Entity>) -> Unit,
            update: () -> Unit
        ): GameTurn {
            return GameTurn(
                entities = getEntitiesForNewGame(),
                gameOver = gameOver,
                update = update
            )
        }

        private fun getEntitiesForNewGame(): List<Entity> = listOf(
            Player(),
            Monster(),
            Monster(),
            Monster()
        )
    }
}
