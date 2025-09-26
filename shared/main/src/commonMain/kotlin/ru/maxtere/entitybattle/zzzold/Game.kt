//package ru.maxtere.entitybattle.game
//
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import ru.maxtere.entitybattle.entities.entity.Entity
//
//class Game {
//    private val _state: MutableStateFlow<GameState> = MutableStateFlow(
//        GameState.newGame(
//            gameOver = ::gameOver,
//            update = ::update
//        )
//    )
//    val state = _state.asStateFlow()
//
//    fun menu() {
//        updateState {
//            GameState.GameMenu(
//                startGame = ::startGame
//            )
//        }
//    }
//
//    fun startGame() {
//        updateState {
//            GameState.newGame(
//                gameOver = ::gameOver,
//                update = ::update
//            )
//        }
//    }
//
//    fun gameOver(entities: List<Entity>) {
//        updateState {
//            GameState.GameOver(
//                entities = entities
//            )
//        }
//    }
//
//    private fun update() {
//        updateState {
//            state.value
//        }
//    }
//
//    private fun updateState(block: GameState.() -> GameState) {
//        _state.value = block(_state.value)
//    }
//}