//package ru.maxtere.entitybattle.entities.entity
//
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.serialization.Serializable
//import kotlin.math.max
//
//@Serializable
//open class Entity___(
//    attributes: EntityAttributes = EntityAttributes.DEFAULT
//) {
//    private val _attributes = MutableStateFlow(
//        attributes
//    )
//    val attributes = _attributes.asStateFlow()
//
//
//
//
//    val isAlive
//        get() = (attributes.value.healthPoints > 0)
//
//    fun tryAttack(entity: Entity___): Int {
//        println("if (canAttackWithMod(entity = entity))")
//        if (canAttackWithMod(entity = entity)) {
//            println("return attack(entity = entity)")
//            return attack(entity = entity)
//        }
//        println("return 0")
//        return 0
//    }
//
//    fun canAttack(entity: Entity___): Boolean {
//        println("${(entity.isAlive)} && ${(entity != this)}")
//        return (entity.isAlive) && (entity != this)
//    }
//
//    protected fun updateAttributes(block: EntityAttributes.() -> EntityAttributes) {
//        _attributes.value = block(_attributes.value)
//    }
//
//    private fun attack(entity: Entity___): Int {
//        val damageRange = with(attributes.value) {
//            IntRange(
//                start = minDamagePoints,
//                endInclusive = maxDamagePoints
//            )
//        }
//
//        println("damageRange = $damageRange")
//        val damage = damageRange.random()
//        println("damage = $damage")
//        entity.getDamage(inputDamage = damage)
//        return damage
//    }
//
//    private fun canAttackWithMod(entity: Entity___): Boolean {
//        if (!canAttack(entity = entity)) {
//            return false
//        }
//
//        val modAttack = attributes.value.attackPoints - entity.attributes.value.defensePoints + 1
//        val countRolls = max(modAttack, 1)
//
//        for (i in 1..countRolls) {
//            val resOfRoll = IntRange(1, 6).random()
//
//            if (resOfRoll in 5..6) {
//                return true
//            }
//        }
//        return false
//    }
//
//    private fun getDamage(inputDamage: Int) {
//        println("inputDamage = $inputDamage")
//        println("healthPoints = ${attributes.value.healthPoints}")
//        updateAttributes {
//            copy(healthPoints = healthPoints - inputDamage)
//        }
//        println("healthPoints = ${attributes.value.healthPoints}")
//    }
//}