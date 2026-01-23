package day8

import kotlin.math.pow
import kotlin.math.sqrt

data class ConnectedJunctionBoxes(val junctionBoxA: JunctionBox, val junctionBoxB: JunctionBox) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ConnectedJunctionBoxes

        if (junctionBoxA != other.junctionBoxA && junctionBoxA != other.junctionBoxB) return false
        if (junctionBoxB != other.junctionBoxB && junctionBoxB != other.junctionBoxA) return false

        return true
    }

    override fun hashCode(): Int {
        val h1 = junctionBoxA.hashCode()
        val h2 = junctionBoxB.hashCode()
        return if (h1 < h2) 31 * h1 + h2 else 31 * h2 + h1
    }
}

fun circuitSize(puzzleInput: String): Int {
    val junctionBoxes = parse(puzzleInput)
    return circuits(
        makeCircuits(junctionBoxes, 10).connectedJunctionBoxes)
        .map { it.size }
        .sortedDescending()
        .take(3)
        .reduce { acc, i -> acc * i }
}

fun makeCircuits(junctionBoxes: Set<JunctionBox>, numberOfLightStrings: Int): JunctionBoxesCircuits {
    // 1. Generate all unique pairs and sort them by distance.
    val allPossibleConnections = junctionBoxes
        .asSequence()
        .withIndex()
        .flatMap { (i, jb1) ->
            junctionBoxes.asSequence().withIndex()
                .filter { (j, _) -> i < j }
                .map { (_, jb2) -> ConnectedJunctionBoxes(jb1, jb2) }
        }
        .toList()
        .sortedBy { it.junctionBoxA.distanceTo(it.junctionBoxB) }

    // 2. Take only the top N connections to process.
    val connectionsToProcess = allPossibleConnections.take(numberOfLightStrings)

    val finalConnectedJunctionBoxes = mutableSetOf<ConnectedJunctionBoxes>()

    // 3. Iterate through just the top N connections and add them if valid.
    for (connection in connectionsToProcess) {
        // Check against the circuits formed by the connections added so far.
        val currentCircuits = circuits(finalConnectedJunctionBoxes)
        if (currentCircuits.none { it.contains(connection.junctionBoxA) && it.contains(connection.junctionBoxB) }) {
            finalConnectedJunctionBoxes.add(connection)
        }
    }

    return JunctionBoxesCircuits(junctionBoxes, finalConnectedJunctionBoxes)
}

data class JunctionBoxesCircuits(val junctionBoxes: Set<JunctionBox>, val connectedJunctionBoxes: Set<ConnectedJunctionBoxes>)

data class JunctionBox(val x: Int, val y: Int, val z: Int)

fun JunctionBox.distanceTo(other: JunctionBox): Double {
    val (x2, y2, z2) = other
    return sqrt(
        (x - x2).toDouble().pow(2.0) + (y - y2).toDouble().pow(2.0) + (z - z2).toDouble().pow(2.0)
    )
}