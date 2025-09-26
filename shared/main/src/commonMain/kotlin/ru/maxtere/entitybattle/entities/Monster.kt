package ru.maxtere.entitybattle.entities

import ru.maxtere.entitybattle.entities.entity.Entity

data class Monster(
    override val healthPoints: Int,
    override val defensePoints: Int,
    override val attackPoints: Int,
    override val minDamagePoints: Int,
    override val maxDamagePoints: Int
) : Entity(
    healthPoints = healthPoints,
    defensePoints = defensePoints,
    attackPoints = attackPoints,
    minDamagePoints = minDamagePoints,
    maxDamagePoints = maxDamagePoints,
)