package ru.maxtere.sample.app.android

import android.app.Application

//import org.koin.android.ext.koin.androidContext
//import org.koin.core.context.startKoin
//import ru.maxtere.binlist.di.getBINModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

//        startKoin {
//            androidContext(this@MainApplication)
//            modules(
//                getBINModule(),
//                getPlatformModule()
//            )
//        }
    }
}