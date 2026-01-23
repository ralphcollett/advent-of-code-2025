package day10

import day10.IndicatorLightStates.OFF
import kotlin.test.Test
import kotlin.test.assertEquals

class MachineTest {

    @Test
    fun `Machine buttons all off by default`() {
        val machine = Machine(3)

        assertEquals(listOf(OFF, OFF, OFF), machine.indicatorLights)
    }
}