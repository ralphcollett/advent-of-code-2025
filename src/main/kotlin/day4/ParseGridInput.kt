package day4

fun parse(puzzleInput: String): Grid {
    val rows = puzzleInput.split("\n")
    val longestRowLength = rows.maxOf { it.length }
    return rows.take(longestRowLength).map { row ->
        row.map {
            when (it) {
                '.' -> GridCellContents.EMPTY
                '@' -> GridCellContents.ROLL_OF_PAPER
                else -> return emptyList()
            }
        }
    }
}