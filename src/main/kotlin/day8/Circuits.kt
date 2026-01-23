package day8

typealias Circuit = Set<JunctionBox>

fun circuits(connectedJunctionBoxes: List<ConnectedJunctionBoxes>): List<Circuit> {
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