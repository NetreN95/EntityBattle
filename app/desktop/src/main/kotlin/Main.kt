import ru.maxtere.entitybattle.entities.entity.Monster

fun main() {
    test()
//    initKoin()
//
//    application {
//        Window(
//            title = "Entity battle",
//            onCloseRequest = ::exitApplication,
//            state = WindowState(
//                size = DpSize(400.dp, 800.dp)
//            ),
//            resizable = false
//        ) {
//            App()
//        }
//    }
}

fun test() {
    val entity1 = Monster(
        healthPoints = 100,
        defensePoints = 100,
        attackPoints = 100,
        minDamagePoints = 5,
        maxDamagePoints = 20
    )

    val entity2 = Monster(
        healthPoints = 100,
        defensePoints = 100,
        attackPoints = 100,
        minDamagePoints = 5,
        maxDamagePoints = 20
    )

    println("entity2.healthPoints = ${entity2.healthPoints}")
    println("entity2.maxHealth = ${entity2.maxHealth}")
    entity1.attack(entity2)
    println("entity2.healthPoints = ${entity2.healthPoints}")
    println("entity2.maxHealth = ${entity2.maxHealth}")
}