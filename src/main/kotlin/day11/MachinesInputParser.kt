package day11

fun parse(puzzleInput: String): List<Device> {
    return puzzleInput.split("\n").mapNotNull { deviceInput ->
        val name = deviceInput.substringBefore(":", "").takeIf { it.isNotEmpty() } ?: return@mapNotNull null
        val connectedDeviceNames = deviceInput.substringAfter(": ").split(" ")
        Device(
            name,
            connectedDeviceNames
        )
    }
}