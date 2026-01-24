package day11

data class Device(val name: String, val connectedDeviceNames: List<String>)

private const val END_DEVICE_NAME = "end"

private const val YOU_DEVICE_NAME = "you"

fun pathsFromYouToEnd(devices: List<Device>): List<List<String>> {
    val youDevice = devices.find { it.name == YOU_DEVICE_NAME } ?: return emptyList()
    val devicesWithEnd = devices + Device(END_DEVICE_NAME, emptyList())

    fun pathToEnd(currentPosition: Device, pathsSoFar: List<List<String>>): List<List<String>> {
        return pathsSoFar.flatMap { pathSoFar ->
            when {
                currentPosition.name == END_DEVICE_NAME -> listOf(pathSoFar + END_DEVICE_NAME)
                END_DEVICE_NAME in pathSoFar -> listOf(pathSoFar)
                else -> currentPosition.connectedDeviceNames.filterNot { it in pathSoFar }.mapNotNull { nextDeviceName ->
                    devicesWithEnd.find { it.name == nextDeviceName }?.let { nextDevice ->
                        val pathSoFarWithCurrentPosition = pathSoFar + currentPosition.name
                        val updatedPaths = listOf(* pathsSoFar.filterNot { it == pathSoFar}.toTypedArray(), pathSoFarWithCurrentPosition)
                        pathToEnd(nextDevice, updatedPaths)
                    }
                }.flatten()
            }
        }
    }

    return youDevice.connectedDeviceNames.flatMap { connectedDeviceName ->
        devicesWithEnd.find { device -> device.name == connectedDeviceName }?.let {
            pathToEnd(it, listOf(listOf(YOU_DEVICE_NAME)))
        } ?: emptyList()
    }
}