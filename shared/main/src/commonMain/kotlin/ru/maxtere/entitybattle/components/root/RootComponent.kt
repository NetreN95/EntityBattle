package ru.maxtere.entitybattle.components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import kotlinx.serialization.Serializable
import ru.maxtere.entitybattle.components.root.RootComponent.Child.Game
import ru.maxtere.entitybattle.components.root.RootComponent.Child.GameOver
import ru.maxtere.entitybattle.components.root.RootComponent.Child.Menu
import ru.maxtere.entitybattle.entities.entity.Entity

class RootComponent(
    context: ComponentContext
) : ComponentContext by context {
    private val navigation = StackNavigation<Config>()
    val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        childFactory = ::createStack,
        initialConfiguration = Config.Menu,
        handleBackButton = true
    )

    private fun createStack(
        config: Config,
        context: ComponentContext
    ) = when (config) {
        is Config.Menu -> Menu()
        is Config.Game -> Game()
        is Config.GameOver -> GameOver()
    }

    private fun clickOnBack() = navigation.pop()

    @Serializable
    sealed interface Config {
        @Serializable
        data object Menu : Config

        @Serializable
        data class Game(
            val entities: List<Entity> = listOf()
        ) : Config

        @Serializable
        data object GameOver : Config
    }

    sealed interface Child {
        class Menu() : Child
        data class Game(
            val entities: List<Entity> = listOf()
        ) : Child

        class GameOver() : Child
    }
}