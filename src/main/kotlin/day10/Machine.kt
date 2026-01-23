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

data class Machine private constructor(val indicatorLights: IndicatorLightDiagram) {

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

    fun findFewestPressesToMeetIndicatorDiagram(manual: MachineManual): Int? {
        val (indicatorLightDiagram, buttonWiring) = manual

        fun count(machine: Machine, lightSwitchCount: Int, previousMachines: List<Machine>): Int? {
            return buttonWiring.mapNotNull { buttonWiringSchematic ->
                val toggledMachine =
                    buttonWiringSchematic.fold(machine) { machine, lightIndex -> machine.toggle(lightIndex) }
                when {
                    (toggledMachine.indicatorLights == indicatorLightDiagram) -> lightSwitchCount + 1
                    toggledMachine in previousMachines -> null
                    else -> count(toggledMachine, lightSwitchCount + 1, previousMachines + toggledMachine)
                }
            }.minOrNull()
        }
        return when (indicatorLights) {
            indicatorLightDiagram -> 0
            else -> count(this, 0, listOf(this))
        }
    }
}
