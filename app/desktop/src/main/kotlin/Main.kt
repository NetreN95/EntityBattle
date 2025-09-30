import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() {
//    test()

//    initKoin()
//
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

//fun test() {
//    val entity1 = Monster(
//        healthPoints = 100,
//        defensePoints = 100,
//        attackPoints = 100,
//        minDamagePoints = 5,
//        maxDamagePoints = 20
//    )
//
//    val entity2 = Monster(
//        healthPoints = 100,
//        defensePoints = 100,
//        attackPoints = 100,
//        minDamagePoints = 5,
//        maxDamagePoints = 20
//    )
//
//    entity1.tryAttack(entity2)
//}