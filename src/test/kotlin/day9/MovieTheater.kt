package day9


fun findLargestRectangle(puzzleInput: String): Int {
    val redTiles = parse(puzzleInput)
    return redTiles.flatMap { tile1 ->
        redTiles.mapNotNull { tile2 ->
            when {
                tile1 != tile2 -> tile1 to tile2
                else -> null
            }
        }
    }.maxOf { (tile1, tile2) -> area(tile1, tile2) }
}