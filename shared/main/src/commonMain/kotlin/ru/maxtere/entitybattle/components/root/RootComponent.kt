package ru.maxtere.entitybattle.components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import kotlinx.serialization.Serializable
import ru.maxtere.entitybattle.entities.entity.Entity

class RootComponent(
    context: ComponentContext
) : ComponentContext by context {
    private val navigation = StackNavigation<Config>()
//    val stack = childStack(
//        source = navigation,
//        serializer = Config.serializer(),
//        childFactory = ::createStack,
//        initialConfiguration = Config.Users,
//        handleBackButton = true
//    )
//
//    private fun createStack(
//        config: Config,
//        context: ComponentContext
//    ) = when (config) {
//        is Config.Users -> Child.Users(component = users)
//
//        is Config.DetailUser -> Child.DetailUser(
//            component = UserDetailComponent(
//                context = context,
//                user = config.user,
//                onBackClick = ::clickOnBack,
//                appStarter = appStarter
//            )
//        )
//    }

    private fun clickOnBack() = navigation.pop()

    @Serializable
    sealed interface Config {
        @Serializable
        data object Menu : Config

        //        @Serializable
        data class Game(val entities: List<Entity>) : Config

        @Serializable
        data object GameOver : Config
    }

    sealed interface Child {
        class Menu() : Child
        class Game(val entities: List<Entity>) : Child
    }
}
