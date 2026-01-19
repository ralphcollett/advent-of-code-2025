package day1

fun parse(commands: String): Rotation {
    return Rotation(Direction.LEFT, commands.substring(1).toInt())
}
