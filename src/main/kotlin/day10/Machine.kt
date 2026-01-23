package day10

import day10.IndicatorLightStates.OFF

enum class IndicatorLightStates {
    ON, OFF
}

typealias IndicatorLightDiagram = List<IndicatorLightStates>

typealias ButtonWiringSchematic = List<Int>

data class MachineManual(
    val indicatorLightDiagram: IndicatorLightDiagram,
    val buttonWiring: List<ButtonWiringSchematic>
)

data class Machine(private val indicatorLineCount: Int) {

    val indicatorLights = List(3){ OFF}
}
