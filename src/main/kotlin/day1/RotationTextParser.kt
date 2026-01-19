package day1

fun parse(commands: String): Rotation {
    val distance = commands.substring(1).toInt()
    return if (commands[0] == 'L') {
        Rotation(Direction.LEFT, distance)
    } else {
        Rotation(Direction.RIGHT, distance)
    }
}
