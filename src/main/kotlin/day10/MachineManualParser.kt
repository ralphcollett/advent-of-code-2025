package day10

fun parse(puzzleInput: String): List<MachineManual> {
    return puzzleInput.split("\n").map { machineInput ->
        val indicatorLightInput = machineInput.substringAfter("[").substringBefore("]")
        val indicatorLightDiagram = indicatorLightInput.mapNotNull {
            when (it) {
                '.' -> IndicatorLightState.OFF
                '#' -> IndicatorLightState.ON
                else -> null
            }
        }
        val buttonWiringInputs = machineInput.substringAfter("]").substringBefore("{").trim().split("\\s+".toRegex())
        val buttonWiring = buttonWiringInputs.map { buttonWiringInput ->
            buttonWiringInput.substringAfter("(").substringBefore(")").split(",").mapNotNull {
                it.toIntOrNull()
            }
        }
        MachineManual(indicatorLightDiagram, buttonWiring)
    }
}