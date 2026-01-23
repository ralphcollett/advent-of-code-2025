package day9

fun parse(puzzleInput: String): List<Tile> {
    return puzzleInput.split("\n").mapNotNull { row ->
        row.split(",")
            .mapNotNull { it.toIntOrNull() }
            .takeIf { it.size == 2 }
            ?.let { (x, y) ->
                Tile(x, y)
            }
    }
}