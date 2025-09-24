package ru.maxtere.entitybattle.ui.compose.screens.states

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.maxtere.entitybattle.entities.Player
import ru.maxtere.entitybattle.entities.entity.Entity
import ru.maxtere.entitybattle.game.GameState
import ru.maxtere.entitybattle.game.GameState.GameTurn
import ru.maxtere.entitybattle.game.extensions.currentEntity
import ru.maxtere.entitybattle.game.extensions.onAttack
import ru.maxtere.entitybattle.game.extensions.onHealSelf
import ru.maxtere.entitybattle.ui.compose.views.EntitiesList

@Composable
fun GameTurnScreen(state: GameState.GameTurn) {
    GameTurnScreen(
        entities = state.entities,
        buttonByEntity = state::currentButton
    )
}

@Composable
fun GameTurnScreen(
    entities: List<Entity>,
    buttonByEntity: (Entity) -> ButtonByEntity?,
) {
    Column {
        EntitiesList(
            entities = entities,
            buttonByEntity = buttonByEntity
        )
    }
}

data class ButtonByEntity(
    val onclick: () -> Unit,
    val text: String,
    val enabled: Boolean,
    val color: Color
)

fun GameTurn.currentButton(entity: Entity): ButtonByEntity? {
    when (currentEntity) {
        is Player -> {


            return if (currentEntity == entity) {
                println("(currentEntity as Player).canHealSelf = ${(currentEntity as Player).canHealSelf}")

                ButtonByEntity(
                    onclick = this::onHealSelf,
                    text = "Лечить",
                    enabled = (currentEntity as Player).canHealSelf,
                    color = Color.Green
                )
            } else {
                ButtonByEntity(
                    onclick = {this.onAttack(entity = entity)},
                    text = "Атаковать",
                    enabled = currentEntity?.canAttack(entity = entity) == true,
                    color = Color.Red
                )
            }
        }
    }
    return null
}