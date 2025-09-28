package ru.maxtere.entitybattle.ui.compose.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ru.maxtere.entitybattle.entities.entity.Entity
import ru.maxtere.sdk.ui.compose.SpacerWidth

//@Composable
//fun EntityAttributes(attributes: EntityAttributes) {
//    Column {
//        with(attributes) {
//            EntityAttribute(
//                name = "Health Points",
//                value = "${healthPoints}/${maxHealth}"
//            )
//            EntityAttribute(name = "Defend Points", value = defensePoints)
//            EntityAttribute(name = "Attack Points", value = attackPoints)
//            EntityAttribute(
//                name = "Damage",
//                value = "$minDamagePoints - $maxDamagePoints"
//            )
//        }
//    }
//}

@Composable
fun EntityAttributes(entity: Entity) {
    Column {
        with(entity) {
            println("EntityAttributes")
            EntityAttribute(
                name = "Health Points",
                value = "${healthPoints}/${maxHealth}"
            )
            EntityAttribute(name = "Defend Points", value = defensePoints)
            EntityAttribute(name = "Attack Points", value = attackPoints)
            EntityAttribute(
                name = "Damage",
                value = "$minDamagePoints - $maxDamagePoints"
            )
        }
    }
}

@Composable
fun EntityAttribute(name: String, value: Int) {
    EntityAttribute(name = name, value = value.toString())
}

@Composable
fun EntityAttribute(name: String, value: String) {
    Row {
        Text(text = name)
        SpacerWidth()
        Text(text = value)
    }
}