package day8

fun parse(puzzleInput: String): Set<JunctionBox> {
    return puzzleInput.split("\n")
        .mapNotNull { row -> row.split(",")
            .mapNotNull { coordinate -> coordinate.toIntOrNull() }
            .takeIf { it.size == 3 }
        }
        .map { (x, y, z) -> JunctionBox(x, y, z) }
        .toSet()
}