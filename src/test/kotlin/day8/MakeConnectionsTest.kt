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

        val expected = JunctionBoxesCircuits(
            junctionBoxes,
            listOf(ConnectedJunctionBoxes(junctionBoxes[0], junctionBoxes[1]))
        )

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

        val expected = JunctionBoxesCircuits(
            junctionBoxes,
            listOf(
                ConnectedJunctionBoxes(JunctionBox(1, 1, 1), JunctionBox(2, 2, 2))
            )
        )

        assertEquals(expected, circuits)
    }

    @Test
    fun `Finds multiple junction boxes`() {
        val junctionBoxes = listOf(
            JunctionBox(162, 817, 812),
            JunctionBox(431, 825, 988),
            JunctionBox(739, 650, 466),
            JunctionBox(425, 690, 689)
        )

        val circuits = makeCircuits(
            junctionBoxes, 2
        )

        val expected = JunctionBoxesCircuits(
            junctionBoxes,
            listOf(
                ConnectedJunctionBoxes(JunctionBox(162, 817, 812), JunctionBox(425, 690, 689)),
                ConnectedJunctionBoxes(JunctionBox(162, 817, 812), JunctionBox(431, 825, 988))
            )
        )

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