package day8

typealias ConnectedJunctionBoxes = Pair<JunctionBox, JunctionBox>

fun circuitSize(puzzleInput: String): Int {
    val junctionBoxes = parse(puzzleInput)
    makeConnections(junctionBoxes, 10)
    TODO("Not yet implemented")
}

fun makeConnections(junctionBoxes: List<JunctionBox>, numberOfLightStrings: Int) {
    TODO("Not yet implemented")
}

data class JunctionBoxesCircuits(val junctionBoxes: List<JunctionBox>, val connectedJunctionBoxes: List<ConnectedJunctionBoxes>)

data class JunctionBox(val x: Int, val y: Int, val z: Int)