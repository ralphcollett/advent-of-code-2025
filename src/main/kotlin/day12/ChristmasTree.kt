package day12

enum class PresentShapeCell {
    PART_OF_SHAPE, EMPTY
}

data class PresentPuzzleInput(val index: Int, val shape: List<List<PresentShapeCell>>)

data class RegionUnderTreePuzzleInput(val width: Int, val height: Int, val quantityOfPresents: List<Int>)

data class ChristmasTreePuzzleInput(val presentPuzzleInpuses: List<PresentPuzzleInput>, val regions: List<RegionUnderTreePuzzleInput>)

fun countRegionsThatCanFitAllPresents(puzzleInput: String): Int {
    TODO("Not yet implemented")
}