package ru.maxtere.entitybattle.di

import org.koin.core.context.startKoin
import ru.maxtere.entitybattle.di.modules.CommonKoinModule


fun initKoin() = startKoin {
    modules(
        CommonKoinModule.gameModule
    )
}