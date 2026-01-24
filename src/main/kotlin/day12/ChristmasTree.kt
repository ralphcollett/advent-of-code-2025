package day12

import day12.PresentShapeCell.EMPTY

enum class PresentShapeCell {
    PART_OF_SHAPE, EMPTY
}

data class RegionUnderTree(val width: Int, val height: Int) {
    val units: List<List<PresentShapeCell>> = List(height) { List(width) { EMPTY } }
}

data class PresentPuzzleInput(val index: Int, val units: List<List<PresentShapeCell>>)

data class RegionUnderTreePuzzleInput(val width: Int, val height: Int, val quantityOfPresents: List<Int>)

data class ChristmasTreePuzzleInput(val presentPuzzleInputs: List<PresentPuzzleInput>, val regions: List<RegionUnderTreePuzzleInput>)

fun countRegionsThatCanFitAllPresents(puzzleInput: String): Int {
    TODO("Not yet implemented")
}