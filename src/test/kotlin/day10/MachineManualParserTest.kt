package day10

import day10.IndicatorLightStates.OFF
import day10.IndicatorLightStates.ON
import kotlin.test.Test
import kotlin.test.assertEquals

class MachineManualParserTest {

    @Test
    fun `Parses puzzle input`() {
        val puzzleInput = """
            [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
            [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
        """.trimIndent()

        val expectedManual = listOf(
            MachineManual(
                listOf(OFF, ON, ON, OFF),
                listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1))
            ), MachineManual(
                listOf(OFF, OFF, OFF, ON, OFF),
                listOf(listOf(0, 2, 3, 4), listOf(2, 3), listOf(0, 4), listOf(0, 1, 2), listOf(1, 2, 3, 4))
            )
        )

        assertEquals(expectedManual, parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): List<MachineManual> {
        return puzzleInput.split("\n").map { machineInput ->
            val indicatorLightInput = machineInput.substringAfter("[").substringBefore("]")
            val indicatorLightDiagram = indicatorLightInput.mapNotNull {
                when (it) {
                    '.' -> OFF
                    '#' -> ON
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
}