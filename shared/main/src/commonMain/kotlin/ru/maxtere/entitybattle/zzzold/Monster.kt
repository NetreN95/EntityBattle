//package ru.maxtere.entitybattle.entities
//
//import ru.maxtere.entitybattle.entities.entity.Entity
//import ru.maxtere.entitybattle.entities.entity.EntityAttributes
//
//class Monster(
//    attributes: EntityAttributes = EntityAttributes.DEFAULT
//) : Entity(
//    attributes = attributes
//) {
//    fun chooseEntityToAttack(entities: List<Entity>): Entity? {
//        if (!isAlive) {
//            return null
//        }
//        val list = entities.filter { entity ->
//            canAttack(entity)
//        }
//        return list.randomOrNull()
//    }
//}