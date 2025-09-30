package ru.maxtere.entitybattle.entities

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

sealed class Entity(
    attributes: EntityAttributes = EntityAttributes.DEFAULT
) {
    data class EntityAttributes(
        val healthPoints: Int,
        val defensePoints: Int,
        val attackPoints: Int,
        val minDamagePoints: Int,
        val maxDamagePoints: Int,
        val maxHealth: Int = healthPoints
    ) {
        val isAlive = (healthPoints > 0)

        companion object {
            val DEFAULT
                get() = EntityAttributes(
                    healthPoints = 100,
                    defensePoints = 30,
                    attackPoints = 30,
                    minDamagePoints = 1,
                    maxDamagePoints = 20
                )
        }
    }

    private val _attributes = MutableStateFlow(attributes)
    val attributes = _attributes.asStateFlow()

    fun tryAttack(entity: Entity): Int {
        if (canAttackWithMod(entity = entity)) {
            return attack(entity = entity)
        }
        return 0
    }

    fun canAttack(entity: Entity): Boolean {
        return (attributes.value.isAlive) && (entity.attributes.value.isAlive) && (entity !== this)
    }

    private fun attack(entity: Entity): Int {
        val damageRange = IntRange(
            start = attributes.value.minDamagePoints,
            endInclusive = attributes.value.maxDamagePoints
        )

        val damage = damageRange.random()
        entity.getDamage(inputDamage = damage)
        return damage
    }

    private fun canAttackWithMod(entity: Entity): Boolean {
        if (!canAttack(entity = entity)) {
            return false
        }

        val modAttack = attributes.value.attackPoints - entity.attributes.value.defensePoints + 1
        val countRolls = max(modAttack, 1)

        (1..countRolls).forEach { i ->
            val resOfRoll = IntRange(1, 6).random()

            if (resOfRoll in 5..6) {
                return true
            }
        }
        return false
    }

    private fun getDamage(inputDamage: Int) {
        changeHealth(-inputDamage)
    }

    protected fun changeHealth(healthIncrement: Int) {
        _attributes.update {
            it.copy(
                healthPoints = attributes.value.healthPoints + healthIncrement
            )
        }
    }

    class Player(
        attributes: EntityAttributes = EntityAttributes.DEFAULT
    ) : Entity(
        attributes = attributes
    ) {
        private val _percentOfHeal = 30
        private var _countOfHeals = 4

        val maxHeal = maxHeal()

        fun healSelf(): Int {
            if (maxHeal <= 0) {
                return 0
            }

            changeHealth(maxHeal)
            return maxHeal
        }

        private fun maxHeal(): Int {
            if (_countOfHeals <= 0) return 0
            if (attributes.value.healthPoints >= attributes.value.maxHealth) return 0

            return min(
                attributes.value.maxHealth - attributes.value.healthPoints,
                (attributes.value.maxHealth * _percentOfHeal.toDouble() / 100).roundToInt()
            )
        }
    }

    class Monster(
        attributes: EntityAttributes = EntityAttributes.DEFAULT
    ) : Entity(
        attributes = attributes
    ) {
        fun chooseEntityToAttack(entities: List<Entity>): Entity? {
            if (!attributes.value.isAlive) {
                return null
            }
            val list = entities.filter { entity ->
                canAttack(entity)
            }
            return list.randomOrNull()
        }
    }
}