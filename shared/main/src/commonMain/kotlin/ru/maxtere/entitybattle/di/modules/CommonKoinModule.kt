package ru.maxtere.entitybattle.di.modules

import org.koin.dsl.module
import ru.maxtere.entitybattle.game.Game

object CommonKoinModule {
    val gameModule = module {
        single<Game> { Game() }
    }
}
