import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.maxtere.entitybattle.game.Game
import ru.maxtere.entitybattle.ui.compose.EntityItem

@Composable
fun App() {
    val state by Game.state.collectAsState()
    val entities = state.entities
    LazyColumn(
        modifier = Modifier.background(color = Color.White)
    ) {
        items(count = entities.size) { index ->
            EntityItem(
                entity = entities[index],
                buttonsByEntity = Game.currentButtons(entities[index]),
            )
        }
    }
}