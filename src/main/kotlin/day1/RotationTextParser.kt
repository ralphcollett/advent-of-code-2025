package day1

fun parse(commands: String): List<Rotation> {
    fun parseRotation(rotationCommand: String): Rotation {
        val distance = rotationCommand.substring(1).toInt()
        return when {
            rotationCommand[0] == 'L' -> Rotation(Direction.LEFT, distance)
            else -> Rotation(Direction.RIGHT, distance)
        }
    }
    return commands.split("\n").map { parseRotation(it) }
}
