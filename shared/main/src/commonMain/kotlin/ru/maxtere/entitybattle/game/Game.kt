package ru.maxtere.entitybattle.game

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.maxtere.entitybattle.entities.entity.Entity
import ru.maxtere.entitybattle.entities.entity.Entity.Monster
import ru.maxtere.entitybattle.entities.entity.Entity.Player
import ru.maxtere.entitybattle.ui.compose.views.ButtonByEntity

//
//
//class Game {
//
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

object Game {

    private val _state = MutableStateFlow(
        State(
            listOf(
                Player(),
                Monster()
            )
        )
    )

    val state: StateFlow<State> = _state.asStateFlow()

//    private var _currentEntityIndex: Int = 0
//
//    private val _entities: MutableStateFlow<List<Entity>> = MutableStateFlow(
//        listOf(
//            Player(),
//            Monster()
//        )
//    )
//    val entities: StateFlow<List<Entity>> = _entities.asStateFlow()


    //    val aliveEntities get() = entities.value.filter { entity -> entity.isAlive }
    val aliveEntities get() = state.value.entities.filter { entity -> entity.isAlive }

    val currentEntity
        get() = if (state.value.entities.size >= state.value.currentEntityIndex + 1) {
//            entities.value[_currentEntityIndex]
            state.value.entities[state.value.currentEntityIndex]
        } else if (state.value.entities.isEmpty()) {
            null
        } else {
            state.value.entities[state.value.entities.size - 1]
        }

    fun onHealSelf() {
        if (currentEntity is Player) {
            (currentEntity as Player).healSelf()
        }
    }

    fun onAttack(entity: Entity) {
//        currentEntity?.tryAttack(entity = entity)

        val damageRange = IntRange(
            start = entity.minDamagePoints,
            endInclusive = entity.maxDamagePoints
        )

//        println("damageRange = $damageRange")
        val damage = damageRange.random()
//        println("damage = $damage")

        println("entity.hp = ${entity.healthPoints}")

        for (i in 0..state.value.entities.size - 1) {
            if (state.value.entities[i] === entity) {

                _state.value = state.value.copy(
                    entities = state.value.entities.map { it ->
                        if (it === entity) {
                            it.abstractCopy(
                                healthPoints = it.healthPoints - damage
                            )
                        } else {
                            it
                        }
                    }
                )

                break
            }
        }

        println("entity.hp = ${entity.healthPoints}")


//        entity.getDamage(inputDamage = damage)

        nextTurn()
    }

    fun nextTurn() {
        val newIndex = nextAliveEntityIndex()

        println("newIndex = $newIndex")

        if (newIndex == null) {
//            gameOver(entities)
            return
        }

        _state.value = state.value.copy(
            currentEntityIndex = newIndex
        )
        onStartTurn()
    }

    fun nextAliveEntityIndex(): Int? {
        if (state.value.entities.isEmpty()) {
            return 0
        }

        val nextIndex = (state.value.currentEntityIndex + 1) % (state.value.entities.size)
        val maxIndex = state.value.entities.size + state.value.currentEntityIndex - 1

        println("nextIndex = $nextIndex")
        println("maxIndex = $maxIndex")

        for (i in (nextIndex)..maxIndex) {
            with(state.value.entities[i]) {
                if (isAlive) {
                    return i
                }
            }
        }
        return 0
    }

    fun onStartTurn() {
        if (currentEntity == null) {
//            gameOver(entities)
            return
        } else if (aliveEntities.size < 2) {
//            gameOver(entities)
            return
        }



//        _state.value = state.value.copy(
//            entities = state.value.entities
//        )

//        state.value.entities.forEach {
//            println("hp = ${it.healthPoints}")
//        }


//        _entities.value = _entities.value.map { entity ->
//            when (entity) {
//                is Player -> entity.copy()
//                is Monster -> entity.copy()
//            }
//        }

        println("currentEntity = ${currentEntity}")

        when (currentEntity) {
            is Monster -> {
                println("is Monster")
                onStartTurn(monster = currentEntity as Monster)
            }
            else -> {
                println("is Player")
            }
        }
    }

//    fun onAttack(entity: Entity){
//
//    }

    fun onStartTurn(monster: Monster) {
//        val entity = monster.chooseEntityToAttack(entities = entities.value)
        val entity = monster.chooseEntityToAttack(entities = state.value.entities)
        if (entity != null) {
//            monster.tryAttack(entity = entity)
            println("onAttack(entity)")
            onAttack(entity)
            nextTurn()
        } else {
//            gameOver(entities)
        }
    }

    fun currentButton(
        entity: Entity
    ): ButtonByEntity? {
//        println("currentButton: currentEntity = $currentEntity")
        when (currentEntity) {
            is Player -> {

                return if (currentEntity == entity) {
//                    println("(currentEntity as Player).canHealSelf = ${(currentEntity as Player).maxHeal > 0}")

                    ButtonByEntity(
                        onclick = this::onHealSelf,
                        text = "Лечить",
                        enabled = (currentEntity as Player).maxHeal > 0,
                        color = Color.Green
                    )
                } else {
                    ButtonByEntity(
                        onclick = { this.onAttack(entity = entity) },
                        text = "Атаковать",
                        enabled = currentEntity?.canAttack(entity = entity) == true,
                        color = Color.Red
                    )
                }
            }

            is Monster -> {}
            null -> {}
        }
        return null
    }

    data class State(
        val entities: List<Entity>,
        val currentEntityIndex: Int = 0
    )
}