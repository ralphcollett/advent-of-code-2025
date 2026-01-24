package day12

fun parse(puzzleInput: String): ChristmasTreePuzzleInput? {
    val presentsInputSection = puzzleInput.substringBeforeLast("\n\n").split("\n\n")
    val presentPuzzleInpuses = presentsInputSection.map { presentInputSection ->
        val presentIndexRow = presentInputSection.substringBefore("\n")
        val presentIndex = presentIndexRow.substringBefore(":").toInt()
        val presentShapeRows = presentInputSection.substringAfter("\n").split("\n")
        val shape = presentShapeRows.map { presentShapeRow ->
            presentShapeRow.map { presentShapeCell ->
                when (presentShapeCell) {
                    '#' -> PresentShapeCell.PART_OF_SHAPE
                    '.' -> PresentShapeCell.EMPTY
                    else -> return null
                }
            }
        }.takeIf { rows -> rows.distinctBy { it.size }.size == 1 } ?: return null

        PresentPuzzleInput(presentIndex, shape)
    }.takeIf { present ->
        val indexes = present.map { it.index }
        indexes == List(indexes.size) { it }
    } ?: return null

    val regionsInputSection = puzzleInput.substringAfterLast("\n\n")
    val regionsUnderTree = regionsInputSection.split("\n").map { regionInputSection ->
        val (width, height) = regionInputSection.substringBefore(":").split("x").map { it.toInt() }
        val quantityOfPresents = regionInputSection.substringAfter(" ").split(" ").map { it.toInt() }
        RegionUnderTreePuzzleInput(width, height, quantityOfPresents)
    }.takeIf { regions -> regions.all { it.quantityOfPresents.size == presentPuzzleInpuses.size } } ?: return null

    return ChristmasTreePuzzleInput(presentPuzzleInpuses, regionsUnderTree)
}