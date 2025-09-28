package ru.maxtere.entitybattle.entities

//data class Player(
//    override var healthPoints: Int,
//    override val defensePoints: Int,
//    override val attackPoints: Int,
//    override val minDamagePoints: Int,
//    override val maxDamagePoints: Int
//) : Entity(
//    healthPoints = healthPoints,
//    defensePoints = defensePoints,
//    attackPoints = attackPoints,
//    minDamagePoints = minDamagePoints,
//    maxDamagePoints = maxDamagePoints,
//) {
//    private val _percentOfHeal = 30
//    private var _countOfHeals = 4
//
//    val maxHeal get() = maxHeal()
//
//    fun healSelf(): Int {
//        if (maxHeal <= 0) {
//            return 0
//        }
//        healthPoints += maxHeal
//        return maxHeal
//    }
//
//    private fun maxHeal(): Int {
//        if (_countOfHeals <= 0) return 0
//        if (healthPoints >= maxHealth) return 0
//
//        return min(
//            maxHealth - healthPoints,
//            (maxHealth * _percentOfHeal.toDouble()/100).roundToInt()
//        )
//    }
//}