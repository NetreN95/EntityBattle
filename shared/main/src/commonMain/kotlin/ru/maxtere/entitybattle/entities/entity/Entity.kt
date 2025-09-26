package ru.maxtere.entitybattle.entities.entity

import kotlinx.serialization.Serializable

@Serializable
abstract class Entity(
    open val healthPoints: Int,
    open val defensePoints: Int,
    open val attackPoints: Int,
    open val minDamagePoints: Int,
    open val maxDamagePoints: Int,
    val maxHealth: Int = healthPoints
) {
    val isAlive
        get() = (healthPoints > 0)

//    fun attack(entity: Entity) {
//        entity.healthPoints = entity.healthPoints - IntRange(
//            minDamagePoints,
//            maxDamagePoints
//        ).random()
//    }

//    fun tryAttack(entity: Entity): Int {
//        println("if (canAttackWithMod(entity = entity))")
//        if (canAttackWithMod(entity = entity)) {
//            println("return attack(entity = entity)")
//            return attack(entity = entity)
//        }
//        println("return 0")
//        return 0
//    }
//
//    fun canAttack(entity: Entity): Boolean {
//        println("${(entity.isAlive)} && ${(entity != this)}")
//        return (entity.isAlive) && (entity != this)
//    }
//
//    private fun attack(entity: Entity): Int {
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
//    private fun canAttackWithMod(entity: Entity): Boolean {
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
}