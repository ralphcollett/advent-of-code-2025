package day12

enum class PresentShapeCell {
    PART_OF_SHAPE, EMPTY
}

data class Present(val index: Int, val shape: List<List<PresentShapeCell>>)

data class RegionUnderTree(val width: Int, val height: Int, val quantityOfPresents: List<Int>)

data class ChristmasTreePuzzleInput(val presents: List<Present>, val regions: List<RegionUnderTree>)

fun countRegionsThatCanFitAllPresents(puzzleInput: String): Int {
    TODO("Not yet implemented")
}