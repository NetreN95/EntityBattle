import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.maxtere.entitybattle.game.Game
import ru.maxtere.entitybattle.ui.compose.EntityItem

@Composable
fun App() {
    val state by Game.state.collectAsState()
    val entities = state.entities
    LazyColumn {
        items(count = entities.size) { index ->
            EntityItem(
                entity = entities[index],
                buttonsByEntity = Game.currentButtons(entities[index]),
            )
        }
    }
}