package day1

fun parse(commands: String): List<Rotation> {
    val distance = commands.substring(1).toInt()
    return if (commands[0] == 'L') {
        listOf(Rotation(Direction.LEFT, distance))
    } else {
        listOf(Rotation(Direction.RIGHT, distance))
    }
}
