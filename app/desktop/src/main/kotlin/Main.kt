import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ru.maxtere.entitybattle.di.initKoin
import ru.maxtere.entitybattle.ui.compose.App

fun main() {
    initKoin()

    application {
        Window(
            title = "Entity battle",
            onCloseRequest = ::exitApplication,
            state = WindowState(
                size = DpSize(400.dp, 800.dp)
            ),
            resizable = false
        ) {
            App()
        }
    }
}
