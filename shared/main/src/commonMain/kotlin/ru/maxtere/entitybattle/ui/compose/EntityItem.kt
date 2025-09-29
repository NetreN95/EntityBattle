package ru.maxtere.entitybattle.ui.compose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.maxtere.entitybattle.entities.entity.Entity
import ru.maxtere.entitybattle.entities.entity.Entity.*
import ru.maxtere.entitybattle.game.Game
import ru.maxtere.sdk.ui.compose.SpacerWidth

@Composable
fun EntityItem(
    entity: Entity,
    buttonByEntity: ButtonByEntity?,
) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .background(color = Color.Green)
    ) {
        EntityName(
            entity = entity,
            modifier = Modifier
                .fillMaxWidth(0.17f)
                .fillMaxHeight()
                .background(color = Color.Red)
                .align(Alignment.CenterVertically)
        )
        SpacerWidth()
//        EntityAttributes(attributes = entity.attributes.value)
        EntityAttributes(entity = entity)
        SpacerWidth(30.dp)
        EntityMenu(
            entity = entity,
            buttonByEntity = buttonByEntity,
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
    buttonByEntity: ButtonByEntity?,
    modifier: Modifier
) {
    if (buttonByEntity == null) {
        return
    }

//    println("buttonByEntity.text = ${buttonByEntity.text}")
//    println("buttonByEntity.enabled = ${buttonByEntity.enabled}")
//    println("buttonByEntity.color = ${buttonByEntity.color}")

    Button(
        onClick = buttonByEntity.onclick,
        enabled = buttonByEntity.enabled,
        modifier = modifier.background(color = buttonByEntity.color)
    ) {
        Text(text = buttonByEntity.text)
    }
}

data class ButtonByEntity(
    val onclick: () -> Unit,
    val text: String,
    val enabled: Boolean,
    val color: Color
)

