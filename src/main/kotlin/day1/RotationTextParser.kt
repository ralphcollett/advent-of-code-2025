package day1

fun parse(commands: String): List<Rotation> {
    fun parseRotation(rotationCommand: String): Rotation? {
        val distance = rotationCommand.substring(1).toIntOrNull() ?: return null
        val directionCommand = rotationCommand[0]
        return when (directionCommand) {
            'L' -> Rotation(Direction.LEFT, distance)
            'R' -> Rotation(Direction.RIGHT, distance)
            else -> null
        }
    }
    return commands.split("\n").mapNotNull { parseRotation(it) }
}
