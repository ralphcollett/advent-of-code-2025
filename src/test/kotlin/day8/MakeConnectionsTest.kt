package day8

import kotlin.test.Test
import kotlin.test.assertEquals

class MakeConnectionsTest {

    @Test
    fun `Makes connections when 1 light`() {
        val junctionBoxes = listOf(
            JunctionBox(1, 1, 1),
            JunctionBox(2, 2, 2)
        )

        val circuits = makeCircuits(
            junctionBoxes, 1
        )

        val expected = JunctionBoxesCircuits(junctionBoxes, listOf(junctionBoxes[0] to junctionBoxes[1]))

        assertEquals(expected, circuits)
    }
}