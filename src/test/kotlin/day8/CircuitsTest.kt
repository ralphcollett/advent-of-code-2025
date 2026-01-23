package day8

import kotlin.test.Test
import kotlin.test.assertEquals

class CircuitsTest {

    @Test
    fun `Finds circuits`() {
        val connectedJunctionBoxes = setOf(
            ConnectedJunctionBoxes(JunctionBox(1, 1, 1), JunctionBox(2, 2, 2)),
            ConnectedJunctionBoxes(JunctionBox(2, 2, 2), JunctionBox(3, 3, 3)),
            ConnectedJunctionBoxes(JunctionBox(4, 4, 4), JunctionBox(5, 5, 5)),
        )

        val circuits = circuits(connectedJunctionBoxes)

        assertEquals(
            setOf(
                setOf(JunctionBox(1, 1, 1), JunctionBox(2, 2, 2), JunctionBox(3, 3, 3)),
                setOf(JunctionBox(4, 4, 4), JunctionBox(5, 5, 5)),
            ), circuits
        )
    }
}