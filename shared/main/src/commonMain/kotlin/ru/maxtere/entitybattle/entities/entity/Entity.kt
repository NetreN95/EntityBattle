package ru.maxtere.entitybattle.entities.entity

import kotlinx.serialization.Serializable
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

@Serializable
sealed class Entity(
    open var healthPoints: Int,
    open val defensePoints: Int,
    open val attackPoints: Int,
    open val minDamagePoints: Int,
    open val maxDamagePoints: Int,
    val maxHealth: Int = healthPoints
) {
    val isAlive
        get() = (healthPoints > 0)

//    private val _id: Int = IntRange(
//        Int.MIN_VALUE,
//        Int.MAX_VALUE
//    ).random()

    fun tryAttack(entity: Entity): Int {
        println("if (canAttackWithMod(entity = entity))")
        if (canAttackWithMod(entity = entity)) {
            println("return attack(entity = entity)")
            return attack(entity = entity)
        }
        println("return 0")
        return 0
    }

    fun canAttack(entity: Entity): Boolean {
        println("${(entity.isAlive)} && ${(entity !== this)}")
        return (entity.isAlive) && (entity !== this)
    }

    private fun attack(entity: Entity): Int {
        val damageRange = IntRange(
            start = minDamagePoints,
            endInclusive = maxDamagePoints
        )

        println("damageRange = $damageRange")
        val damage = damageRange.random()
        println("damage = $damage")
        entity.getDamage(inputDamage = damage)
        return damage
    }

    private fun canAttackWithMod(entity: Entity): Boolean {
        if (!canAttack(entity = entity)) {
            return false
        }

        val modAttack = attackPoints - entity.defensePoints + 1
        val countRolls = max(modAttack, 1)

        for (i in 1..countRolls) {
            val resOfRoll = IntRange(1, 6).random()

            if (resOfRoll in 5..6) {
                return true
            }
        }
        return false
    }

    private fun getDamage(inputDamage: Int) {
        println("healthPoints = $healthPoints")
        healthPoints -= inputDamage
        println("healthPoints = $healthPoints")
    }

//    override fun hashCode(): Int = _id
//    override fun equals(other: Any?): Boolean {
//        println("equals")
//
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        return true
//    }

    data class Player(
        override var healthPoints: Int = 100,
        override val defensePoints: Int = 30,
        override val attackPoints: Int = 30,
        override val minDamagePoints: Int = 1,
        override val maxDamagePoints: Int = 20
    ) : Entity(
        healthPoints = healthPoints,
        defensePoints = defensePoints,
        attackPoints = attackPoints,
        minDamagePoints = minDamagePoints,
        maxDamagePoints = maxDamagePoints,
    ) {
        private val _percentOfHeal = 30
        private var _countOfHeals = 4

        val maxHeal get() = maxHeal()

        fun healSelf(): Int {
            if (maxHeal <= 0) {
                return 0
            }
            healthPoints += maxHeal
            return maxHeal
        }

        private fun maxHeal(): Int {
            if (_countOfHeals <= 0) return 0
            if (healthPoints >= maxHealth) return 0

            return min(
                maxHealth - healthPoints,
                (maxHealth * _percentOfHeal.toDouble() / 100).roundToInt()
            )
        }
    }

    data class Monster(
        override var healthPoints: Int = 100,
        override val defensePoints: Int = 30,
        override val attackPoints: Int = 30,
        override val minDamagePoints: Int = 1,
        override val maxDamagePoints: Int = 20
    ) : Entity(
        healthPoints = healthPoints,
        defensePoints = defensePoints,
        attackPoints = attackPoints,
        minDamagePoints = minDamagePoints,
        maxDamagePoints = maxDamagePoints,
    ) {
        fun chooseEntityToAttack(entities: List<Entity>): Entity? {
            if (!isAlive) {
                return null
            }
            val list = entities.filter { entity ->
                canAttack(entity)
            }
            return list.randomOrNull()
        }
    }
}