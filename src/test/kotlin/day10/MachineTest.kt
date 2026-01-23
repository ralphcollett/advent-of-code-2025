package day10

import day10.IndicatorLightState.OFF
import day10.IndicatorLightState.ON
import kotlin.test.Test
import kotlin.test.assertEquals

class MachineTest {

    @Test
    fun `Machine buttons all off by default`() {
        val machine = Machine(3)

        assertEquals(listOf(OFF, OFF, OFF), machine.indicatorLights)
    }

    @Test
    fun `Can toggle a light on`() {
        val machine = Machine(4).toggle(2)

        assertEquals(listOf(OFF, OFF, ON, OFF), machine.indicatorLights)
    }

    @Test
    fun `Can toggle a light off`() {
        val machine = Machine(3)
            .toggle(1)
            .toggle(1)

        assertEquals(listOf(OFF, OFF, OFF), machine.indicatorLights)
    }

    @Test
    fun `Knows need no button presses when all lights off in diagram`() {
        val buttonPresses = Machine(4).findFewestPressesToMeetIndicatorDiagram(
            MachineManual(
                listOf(OFF, OFF, OFF, OFF),
                listOf(listOf(2))
            )
        )

        assertEquals(0, buttonPresses)
    }

    @Test
    fun `Finds fewest button presses to meet an indicator light diagram when one`() {
        val buttonPresses = Machine(4).findFewestPressesToMeetIndicatorDiagram(
            MachineManual(
                listOf(OFF, OFF, ON, OFF),
                listOf(listOf(2))
            )
        )

        assertEquals(1, buttonPresses)
    }

    @Test
    fun `Finds fewest presses when multiple options`() {
        val buttonPresses = Machine(4).findFewestPressesToMeetIndicatorDiagram(
            MachineManual(
                listOf(OFF, ON, ON, OFF),
                listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1))
            )
        )

        assertEquals(2, buttonPresses)
    }
}