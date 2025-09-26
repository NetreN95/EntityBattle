//package ru.maxtere.entitybattle.game.extensions
//
//import ru.maxtere.entitybattle.entities.Monster
//import ru.maxtere.entitybattle.entities.Player
//import ru.maxtere.entitybattle.entities.entity.Entity
//import ru.maxtere.entitybattle.game.GameState.GameTurn
//
//val GameTurn.currentEntity: Entity?
//    get() = if (entities.size >= currentEntityIndex + 1) {
//        entities[currentEntityIndex]
//    } else if (entities.isEmpty()) {
//        null
//    } else {
//        entities[entities.size - 1]
//    }
//
//val GameTurn.aliveEntities get() = entities.filter { entity -> entity.isAlive }
//
//fun GameTurn.nextAliveEntityIndex(): Int? {
//    if (entities.isEmpty()) {
//        return 0
//    }
//
//    val nextIndex = (currentEntityIndex + 1) % (entities.size - 1)
//    val maxIndex = entities.size + currentEntityIndex - 2
//
//    for (i in (nextIndex)..maxIndex) {
//        with(entities[i]) {
//            if (isAlive) {
//                return i
//            }
//        }
//    }
//    return 0
//}
//
//fun GameTurn.onStartTurn() {
//    if (currentEntity == null) {
//        gameOver(entities)
//        return
//    } else if (aliveEntities.size < 2) {
//        gameOver(entities)
//        return
//    }
//    when (currentEntity) {
//        is Monster -> onStartTurn(monster = currentEntity as Monster)
//    }
//}
//
//fun GameTurn.onStartTurn(monster: Monster) {
//    val entity = monster.chooseEntityToAttack(entities = entities)
//    if (entity != null) {
//        monster.tryAttack(entity = entity)
//        nextTurn()
//    } else {
//        gameOver(entities)
//    }
//}
//
//fun GameTurn.onHealSelf() {
//    if (currentEntity is Player) {
//        (currentEntity as Player).healSelf()
//    }
//}
//
//fun GameTurn.onAttack(entity: Entity) {
//    currentEntity?.tryAttack(entity = entity)
//    nextTurn()
//    update()
//}