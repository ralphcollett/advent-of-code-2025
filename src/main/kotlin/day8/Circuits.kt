package day8

typealias Circuit = Set<JunctionBox>

fun circuits(connectedJunctionBoxes: Set<ConnectedJunctionBoxes>): Set<Circuit> {
    return buildCircuits(connectedJunctionBoxes, emptySet())
}

private fun buildCircuits(connectedJunctionBoxes: Set<ConnectedJunctionBoxes>, circuits: Set<Set<JunctionBox>>): Set<Set<JunctionBox>> {
    if (connectedJunctionBoxes.isEmpty()) return circuits

    val connectedJunctionBox = connectedJunctionBoxes.first()

    val updatedCircuits: Set<Set<JunctionBox>> =
        when {
            circuits.none { circuit -> connectedJunctionBox.junctionBoxA in circuit || connectedJunctionBox.junctionBoxB in circuit }
                -> circuits + setOf((setOf(connectedJunctionBox.junctionBoxA, connectedJunctionBox.junctionBoxB)))
            else -> circuits.map { circuit ->
                if (circuit.any { it == connectedJunctionBox.junctionBoxA || it == connectedJunctionBox.junctionBoxB }) circuit + connectedJunctionBox.junctionBoxA + connectedJunctionBox.junctionBoxB
                else circuit
            }.toSet()
        }

    return buildCircuits(connectedJunctionBoxes - connectedJunctionBox, updatedCircuits)
}