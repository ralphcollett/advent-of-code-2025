package day12

import day12.PresentShapeCell.EMPTY
import day12.PresentShapeCell.PART_OF_SHAPE

enum class PresentShapeCell {
    PART_OF_SHAPE, EMPTY
}

class RegionUnderTree private constructor(val units: List<List<PresentShapeCell>>) {

    constructor(width: Int, height: Int): this(List(height) { List(width) { EMPTY } })

    fun insert(present: List<List<PresentShapeCell>>): RegionUnderTree? {
        val updatedUnits = units.mapIndexed { rowIndex, rows ->
            rows.mapIndexed { columnIndex, cell ->
                val cellToInsert = present.getOrNull(rowIndex)?.getOrNull(columnIndex)
                when (cellToInsert) {
                    null, EMPTY -> cell
                    PART_OF_SHAPE if (cell == EMPTY) -> PART_OF_SHAPE
                    else -> return null
                }
            }
        }
        return RegionUnderTree(updatedUnits)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RegionUnderTree

        return units == other.units
    }

    override fun hashCode(): Int {
        return units.hashCode()
    }

    override fun toString(): String {
        return units.toString()
    }
}

data class PresentPuzzleInput(val index: Int, val units: List<List<PresentShapeCell>>)

data class RegionUnderTreePuzzleInput(val width: Int, val height: Int, val quantityOfPresents: List<Int>)

data class ChristmasTreePuzzleInput(
    val presentPuzzleInputs: List<PresentPuzzleInput>,
    val regions: List<RegionUnderTreePuzzleInput>
)

fun countRegionsThatCanFitAllPresents(puzzleInput: String): Int {
    TODO("Not yet implemented")
}