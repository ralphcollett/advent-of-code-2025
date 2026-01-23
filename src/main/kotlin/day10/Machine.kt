package day10

import day10.IndicatorLightState.OFF

enum class IndicatorLightState {
    ON {
        override fun toggle(): IndicatorLightState = OFF
    },
    OFF {
        override fun toggle(): IndicatorLightState = ON
    };

    abstract fun toggle(): IndicatorLightState
}

typealias IndicatorLightDiagram = List<IndicatorLightState>

typealias ButtonWiringSchematic = List<Int>

data class MachineManual(
    val indicatorLightDiagram: IndicatorLightDiagram,
    val buttonWiring: List<ButtonWiringSchematic>
)

class Machine private constructor(val indicatorLights: IndicatorLightDiagram) {

    constructor(indicatorLineCount: Int) : this(List(indicatorLineCount) { OFF })

    fun toggle(indicatorLightPosition: Int): Machine {
        return Machine(
            indicatorLights.mapIndexed { index, currentLightStatus ->
                when (index) {
                    indicatorLightPosition -> currentLightStatus.toggle()
                    else -> currentLightStatus
                }
            }
        )
    }

    fun findFewestPressesToMeetIndicatorDiagram(manual: MachineManual): Int {
        val (indicatorLightDiagram, buttonWiring) = manual
        return when (indicatorLightDiagram) {
            indicatorLights -> 0
            else -> 1
        }
    }
}
