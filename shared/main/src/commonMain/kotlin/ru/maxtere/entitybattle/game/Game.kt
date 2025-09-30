package ru.maxtere.entitybattle.game

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.maxtere.entitybattle.entities.Entity
import ru.maxtere.entitybattle.entities.Entity.Monster
import ru.maxtere.entitybattle.entities.Entity.Player
import ru.maxtere.entitybattle.ui.compose.ButtonByEntity

object Game {
    private val _state = MutableStateFlow(
        State(
            listOf(
                Player(attributes = Entity.EntityAttributes.DEFAULT),
                Monster(attributes = Entity.EntityAttributes.DEFAULT),
                Monster(attributes = Entity.EntityAttributes.DEFAULT),
                Monster(attributes = Entity.EntityAttributes.DEFAULT)
            )
        )
    )

    val state: StateFlow<State> = _state.asStateFlow()
    val aliveEntities get() = state.value.entities.filter { entity -> entity.attributes.value.isAlive }

    val currentEntity: Entity?
        get() = if (state.value.entities.size >= state.value.currentEntityIndex + 1) {
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
        currentEntity?.tryAttack(entity = entity)

        _state.update {
            it.copy(canAttack = false)
        }
    }

    fun nextTurn() {
        val newIndex = nextAliveEntityIndex()

        if (newIndex == null) {
//            gameOver(entities)
            return
        }

        _state.update {
            it.copy(
                currentEntityIndex = newIndex,
                canAttack = true
            )
        }

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
            with(state.value.entities[i % state.value.entities.size]) {
                if (attributes.value.isAlive) {
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

        when (currentEntity) {
            is Monster -> {
                onStartTurn(monster = currentEntity as Monster)
                return
            }

            else -> {
                return
            }
        }
    }

    fun onStartTurn(monster: Monster) {
        val entity = monster.chooseEntityToAttack(entities = state.value.entities)
        if (entity != null) {
            onAttack(entity)
            nextTurn()
        } else {
//            gameOver(entities)
        }
    }

    fun currentButtons(
        entity: Entity
    ): List<ButtonByEntity> {
        val list: ArrayList<ButtonByEntity> = ArrayList()
        when (currentEntity) {
            is Player -> {
                if (currentEntity == entity) {
                    list.add(
                        ButtonByEntity(
                            onclick = this::onHealSelf,
                            text = "Лечить",
                            enabled = ((currentEntity as Player).maxHeal > 0),
                            color = Color.Green
                        )
                    )
                    list.add(
                        ButtonByEntity(
                            onclick = this::nextTurn,
                            text = "Конец хода",
                            enabled = true,
                            color = Color.Blue
                        )
                    )
                } else {
                    list.add(
                        ButtonByEntity(
                            onclick = { this.onAttack(entity = entity) },
                            text = "Атаковать",
                            enabled = (state.value.canAttack) && (currentEntity?.canAttack(entity = entity) == true),
                            color = Color.Red
                        )
                    )
                }
            }

            else -> {}
        }
        return list
    }

    data class State(
        val entities: List<Entity>,
        val currentEntityIndex: Int = 0,
        val canAttack: Boolean = true
    )
}