import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.maxtere.entitybattle.game.Game
import ru.maxtere.entitybattle.ui.compose.views.EntityItem

@Composable
fun App() {
//    val entities by Game.entities.collectAsState()
    val state by Game.state.collectAsState()
    val entities = state.entities
    println("App")
    LazyColumn {
        items(count = entities.size) { index ->
            println("EntityItem")
            EntityItem(
                entity = entities[index],
//                buttonByEntity = buttonByEntity(entities.value[index]),
                buttonByEntity = Game.currentButton(entities[index]),
            )
        }
    }
}