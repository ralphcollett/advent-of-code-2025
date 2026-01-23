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
    val junctionBoxesCircuits = JunctionBoxesCircuits(junctionBoxes, emptySet())

    return makeCircuits(junctionBoxesCircuits, numberOfLightStrings)
}

private fun makeCircuits(junctionBoxesCircuits: JunctionBoxesCircuits, numberOfLightStrings: Int): JunctionBoxesCircuits {
    if (numberOfLightStrings == 0) return junctionBoxesCircuits

    val (junctionBoxes, connectedJunctionBoxes) = junctionBoxesCircuits
    val circuits = circuits(connectedJunctionBoxes)
    val minimumJunctionBoxes = junctionBoxes.withIndex().mapNotNull { (junctionBoxAIndex, junctionBoxA) ->
        junctionBoxes
            .asSequence()
            .withIndex()
            .filterNot { it.index <= junctionBoxAIndex }
            .map {
                val junctionBox = it.value
                ConnectedJunctionBoxes(junctionBoxA, junctionBox)
            }.filterNot { (junctionBoxA, junctionBoxB) ->
                circuits.any { circuit -> junctionBoxA in circuit && junctionBoxB in circuit }
            }
            .map { it to it.junctionBoxA.distanceTo(it.junctionBoxB) }
            .minByOrNull { it.second }
    }.minBy { it.second }.first

    return makeCircuits(junctionBoxesCircuits.copy(
        connectedJunctionBoxes = connectedJunctionBoxes + minimumJunctionBoxes
    ), numberOfLightStrings - 1)
}

data class JunctionBoxesCircuits(val junctionBoxes: Set<JunctionBox>, val connectedJunctionBoxes: Set<ConnectedJunctionBoxes>)

data class JunctionBox(val x: Int, val y: Int, val z: Int)

fun JunctionBox.distanceTo(other: JunctionBox): Double {
    val (x2, y2, z2) = other
    return sqrt(
        (x - x2).toDouble().pow(2.0) + (y - y2).toDouble().pow(2.0) + (z - z2).toDouble().pow(2.0)
    )
}