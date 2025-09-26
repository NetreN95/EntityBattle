//package ru.maxtere.entitybattle.ui.compose.views
//
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.runtime.Composable
//import ru.maxtere.entitybattle.entities.entity.Entity
//import ru.maxtere.entitybattle.ui.compose.screens.states.ButtonByEntity
//
//@Composable
//fun EntitiesList(
//    entities: List<Entity>,
//    buttonByEntity: (Entity) -> ButtonByEntity?,
//) {
//    LazyColumn {
//        items(count = entities.size) { index ->
//            EntityItem(
//                entity = entities[index],
//                buttonByEntity = buttonByEntity(entities[index]),
//            )
//        }
//    }
//}