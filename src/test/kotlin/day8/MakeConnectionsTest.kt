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
    fun `Does not allow connections if already in same circuit`() {

    }

    @Test
    fun `Find distance between 2 junction boxes`() {
        // SQRT ( (162 - 57)^2 + (817 - 618)^2 + (812 - 52)^2 )
        val distance = JunctionBox(162, 817, 812).distanceTo(
            JunctionBox(57, 618, 57)
        )

        assertEquals(787.8, distance, absoluteTolerance = 0.1)
    }

    @Test
    fun `Finds circuits`() {
        val connectedJunctionBoxes = listOf(
            ConnectedJunctionBoxes(JunctionBox(1, 1, 1), JunctionBox(2, 2, 2)),
            ConnectedJunctionBoxes(JunctionBox(2, 2, 2), JunctionBox(3, 3, 3)),
            ConnectedJunctionBoxes(JunctionBox(4, 4, 4), JunctionBox(5, 5, 5)),
        )

        val circuits = circuits(connectedJunctionBoxes)

        assertEquals(
            listOf(
                setOf(JunctionBox(1, 1, 1), JunctionBox(2, 2, 2), JunctionBox(3, 3, 3)),
                setOf(JunctionBox(4, 4, 4), JunctionBox(5, 5, 5)),
            ), circuits
        )
    }

    private fun circuits(connectedJunctionBoxes: List<ConnectedJunctionBoxes>): List<Set<JunctionBox>> {
        return buildCircuits(connectedJunctionBoxes, emptyList())
    }

    private fun buildCircuits(connectedJunctionBoxes: List<ConnectedJunctionBoxes>, circuits: List<Set<JunctionBox>>): List<Set<JunctionBox>> {
        if (connectedJunctionBoxes.isEmpty()) return circuits

        val connectedJunctionBox = connectedJunctionBoxes.first()

        val updatedCircuits: List<Set<JunctionBox>> =
            when {
                circuits.none { circuit -> connectedJunctionBox.junctionBoxA in circuit || connectedJunctionBox.junctionBoxB in circuit }
                    -> circuits + setOf((setOf(connectedJunctionBox.junctionBoxA, connectedJunctionBox.junctionBoxB)))
                else -> circuits.map { circuit ->
                    if (circuit.any { it == connectedJunctionBox.junctionBoxA || it == connectedJunctionBox.junctionBoxB }) circuit + connectedJunctionBox.junctionBoxA + connectedJunctionBox.junctionBoxB
                    else circuit
                }
            }

        return buildCircuits(connectedJunctionBoxes - connectedJunctionBox, updatedCircuits)
    }
}