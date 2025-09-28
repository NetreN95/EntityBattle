package ru.maxtere.entitybattle.components.game

import com.arkivanov.decompose.ComponentContext
import ru.maxtere.entitybattle.entities.entity.Entity

class GameComponent(
    context: ComponentContext
) : ComponentContext by context {


    data class State(
        val entities: List<Entity>,
        val currentEntityIndex: Int
    )
}