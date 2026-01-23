package day8

import kotlin.math.pow
import kotlin.math.sqrt

typealias ConnectedJunctionBoxes = Pair<JunctionBox, JunctionBox>

fun circuitSize(puzzleInput: String): Int {
    val junctionBoxes = parse(puzzleInput)
    makeCircuits(junctionBoxes, 10)
    TODO("Not yet implemented")
}

fun makeCircuits(junctionBoxes: List<JunctionBox>, numberOfLightStrings: Int): JunctionBoxesCircuits {
    val minimumJunctionBoxes = junctionBoxes.withIndex().mapNotNull { (junctionBoxAIndex, junctionBoxA) ->
        junctionBoxes
            .withIndex()
            .filterNot { it.index <= junctionBoxAIndex }
            .map {
                val junctionBox = it.value
                junctionBoxA to junctionBox to junctionBoxA.distanceTo(junctionBox)
            }.minByOrNull { it.second }
    }.minBy { it.second }.first

    return JunctionBoxesCircuits(junctionBoxes, listOf(
        minimumJunctionBoxes
    ))
}

data class JunctionBoxesCircuits(val junctionBoxes: List<JunctionBox>, val connectedJunctionBoxes: List<ConnectedJunctionBoxes>)

data class JunctionBox(val x: Int, val y: Int, val z: Int)

fun JunctionBox.distanceTo(other: JunctionBox): Double {
    val (x2, y2, z2) = other
    return sqrt(
        (x - x2).toDouble().pow(2.0) + (y - y2).toDouble().pow(2.0) + (z - z2).toDouble().pow(2.0)
    )
}