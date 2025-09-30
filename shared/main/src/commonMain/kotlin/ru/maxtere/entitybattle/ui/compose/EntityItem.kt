package ru.maxtere.entitybattle.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.maxtere.entitybattle.entities.Entity
import ru.maxtere.entitybattle.ui.compose.views.EntityAttributes
import ru.maxtere.sdk.ui.compose.SpacerWidth

@Composable
fun EntityItem(
    entity: Entity,
    buttonsByEntity: List<ButtonByEntity>,
) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        EntityName(
            entity = entity,
            modifier = Modifier
                .fillMaxWidth(0.17f)
                .fillMaxHeight()
                .align(Alignment.CenterVertically)
        )
        SpacerWidth()
        EntityAttributes(entity = entity)
        SpacerWidth(30.dp)
        EntityMenu(
            entity = entity,
            buttonsByEntity = buttonsByEntity,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun EntityName(
    entity: Entity,
    modifier: Modifier
) {
    Text(
        text = entity.javaClass.simpleName,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}

@Composable
fun EntityMenu(
    entity: Entity,
    buttonsByEntity: List<ButtonByEntity>,
    modifier: Modifier
) {
    if (buttonsByEntity.isEmpty()) {
        return
    }

    Column(modifier = modifier) {
        buttonsByEntity.forEach { buttonByEntity ->
            Button(
                onClick = buttonByEntity.onclick,
                enabled = buttonByEntity.enabled,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = buttonByEntity.color
                ),
                modifier = modifier
            ) {
                Text(text = buttonByEntity.text)
            }
        }
    }

}

data class ButtonByEntity(
    val onclick: () -> Unit,
    val text: String,
    val enabled: Boolean,
    val color: Color
)

