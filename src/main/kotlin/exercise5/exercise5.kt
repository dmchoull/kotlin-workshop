package exercise5

// 💯 Bonus Exercise 5: Simple DSL to generate Mars Rovers input files
// https://kotlinlang.org/docs/reference/type-safe-builders.html

// 🧠 Start by defining a mission function that will support the usage see in the test. You will likely want to create
// a few other classes to support the usage shown.

fun mission(init: Mission.() -> Unit): String {
    val mission = Mission()
    mission.init()
    return mission.render()
}

class Mission {
    private lateinit var plateau: Plateau
    private val rovers = mutableListOf<Rover>()

    fun plateau(width: Int, length: Int) {
        plateau = Plateau(width, length)
    }

    fun rover(x: Int, y: Int, direction: String, commands: String) {
        rovers.add(Rover(x, y, direction, commands))
    }

    fun render() = "${plateau.render()}\n${rovers.render()}"

    private fun List<Rover>.render() = joinToString(separator = "\n") { it.render() }
}

data class Plateau(val width: Int, val length: Int) {
    fun render() = "$width $length"
}

data class Rover(val x: Int, val y: Int, val direction: String, val commands: String) {
    fun render() = "$x $y $direction\n$commands"
}
