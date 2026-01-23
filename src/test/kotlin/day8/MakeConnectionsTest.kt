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

    @Test
    fun `Chooses the shortest distance between 2 junction boxes`() {
        val junctionBoxes = listOf(
            JunctionBox(162, 817, 812),
            JunctionBox(1, 1, 1),
            JunctionBox(2, 2, 2),
        )

        val circuits = makeCircuits(
            junctionBoxes, 1
        )

        val expected = JunctionBoxesCircuits(junctionBoxes, listOf(JunctionBox(1, 1, 1) to JunctionBox(2, 2, 2)))

        assertEquals(expected, circuits)
    }

    @Test
    fun `Find distance between 2 junction boxes`() {
        // SQRT ( (162 - 57)^2 + (817 - 618)^2 + (812 - 52)^2 )
        val distance = JunctionBox(162, 817, 812).distanceTo(
            JunctionBox(57, 618, 57)
        )

        assertEquals(787.8, distance, absoluteTolerance = 0.1)
    }

}