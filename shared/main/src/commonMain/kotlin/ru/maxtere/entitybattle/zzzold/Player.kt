//package ru.maxtere.entitybattle.entities
//
//import ru.maxtere.entitybattle.entities.entity.Entity
//import ru.maxtere.entitybattle.entities.entity.EntityAttributes
//import kotlin.math.min
//import kotlin.math.roundToInt
//
//class Player(
//    attributes: EntityAttributes = EntityAttributes.DEFAULT
//) : Entity(
//    attributes = attributes
//) {
//    private var _countOfHeals = 4
//
//    val canHealSelf
//        get() = ((_countOfHeals > 0)
//                && (attributes.value.healthPoints < attributes.value.maxHealth)
//                && (isAlive))
//
//    fun healSelf(): Int {
//        if (!canHealSelf) {
//            return 0
//        }
//
//        with(attributes.value) {
//            val newHP = min(
//                healthPoints + (maxHealth * 0.3).roundToInt(),
//                maxHealth
//            )
//
//            val addHP = newHP - healthPoints
//
//            if (addHP > 0) {
//                updateAttributes {
//                    copy(healthPoints = newHP)
//                }
//                _countOfHeals--
//            }
//
//            return addHP
//        }
//    }
//}