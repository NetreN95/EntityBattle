package ru.maxtere.sample.app.android

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.maxtere.notes.App
import ru.maxtere.notes.di.initKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        initKoin()
        setContent {
            App()
        }
    }
}
