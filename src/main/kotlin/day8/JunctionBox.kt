package day8

typealias ConnectedJunctionBoxes = Pair<JunctionBox, JunctionBox>

fun circuitSize(puzzleInput: String): Int {
    val junctionBoxes = parse(puzzleInput)
    makeCircuits(junctionBoxes, 10)
    TODO("Not yet implemented")
}

fun makeCircuits(junctionBoxes: List<JunctionBox>, numberOfLightStrings: Int): JunctionBoxesCircuits {
    return JunctionBoxesCircuits(junctionBoxes, listOf(
        junctionBoxes[0] to junctionBoxes[1]
    ))
}

data class JunctionBoxesCircuits(val junctionBoxes: List<JunctionBox>, val connectedJunctionBoxes: List<ConnectedJunctionBoxes>)

data class JunctionBox(val x: Int, val y: Int, val z: Int)