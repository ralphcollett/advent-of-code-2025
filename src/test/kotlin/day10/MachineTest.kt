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
}