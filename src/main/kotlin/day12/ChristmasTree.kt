package day12

import day12.PresentShapeCell.EMPTY
import day12.PresentShapeCell.PART_OF_SHAPE

enum class PresentShapeCell {
    PART_OF_SHAPE, EMPTY
}

class RegionUnderTree private constructor(val units: List<List<PresentShapeCell>>) {

    constructor(width: Int, height: Int): this(List(height) { List(width) { EMPTY } })

    private val height = units.size

    private val width = units.first().size

    fun insert(present: List<List<PresentShapeCell>>): List<RegionUnderTree> {
        val shapeRotations = generateSequence(present) { it.rotateClockwise() }.take(4).distinct()
        return (0..height).flatMap { y ->
            (0..width).flatMap { x ->
                shapeRotations.map { shapeRotation ->
                    insertAtPosition(shapeRotation, x, y)
                }
            }
        }.filterNotNull().distinct()
    }

    private fun insertAtPosition(present: List<List<PresentShapeCell>>, x: Int, y: Int): RegionUnderTree? {
        val presentsHeight = present.size
        val presentsWidth = present.first().size
        if (presentsHeight + y > height || presentsWidth + x > width) return null

        val updatedUnits = units.mapIndexed { rowIndex, rows ->
            rows.mapIndexed { columnIndex, cell ->
                val cellToInsert = present.getOrNull(rowIndex - y)?.getOrNull(columnIndex - x)
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
    val regionsInput: List<RegionUnderTreePuzzleInput>
)

fun <T> List<List<T>>.rotateClockwise(): List<List<T>> = List(maxOf { it.size }) { x -> List( size ) { y -> get(y)[x] } }

fun <T> List<List<T>>.flipHorizontal(): List<List<T>> = map { it.reversed() }

fun countRegionsThatCanFitAllPresents(puzzleInput: String): Int {
    return parse(puzzleInput)?.let { countRegionsThatCanFitAllPresents(it) } ?: return 0
}

private fun countRegionsThatCanFitAllPresents(puzzleInput: ChristmasTreePuzzleInput): Int {
    val regionsInput = puzzleInput.regionsInput
    val presentPuzzleInputs = puzzleInput.presentPuzzleInputs
    return regionsInput.count { regionInput ->
        val regionsPuzzleInputs = regionInput
            .quantityOfPresents
            .withIndex()
            .flatMap { (index, quantityOfPresents) ->
                val presentInput = presentPuzzleInputs.find { it.index == index } ?: return@flatMap emptyList()
                List(quantityOfPresents) { presentInput }
            }

        regionsPuzzleInputs.fold(listOf(RegionUnderTree(regionInput.width, regionInput.height))) { regionUnderTree, puzzleInput ->
            regionUnderTree.flatMap { it.insert(puzzleInput.units) }
        }.isNotEmpty()
    }
}