package day12

import day12.PresentShapeCell.EMPTY
import day12.PresentShapeCell.PART_OF_SHAPE

enum class PresentShapeCell {
    PART_OF_SHAPE, EMPTY
}

class RegionUnderTree private constructor(val units: List<List<PresentShapeCell>>) {

    constructor(width: Int, height: Int): this(List(height) { List(width) { EMPTY } })

    val height = units.size

    val width = units.first().size

    fun findAllPossibleInsertions(present: List<List<PresentShapeCell>>): List<RegionUnderTree> {
        val allSymmetries = generateAllSymmetries(present)
        return (0..height).flatMap { y ->
            (0..width).flatMap { x ->
                allSymmetries.map { shapeRotation ->
                    tryInsertAtPosition(shapeRotation, x, y)
                }
            }
        }.filterNotNull().distinct()
    }

    private fun tryInsertAtPosition(present: List<List<PresentShapeCell>>, x: Int, y: Int): RegionUnderTree? {
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

    fun withPresentInserted(present: List<List<PresentShapeCell>>, x: Int, y: Int): RegionUnderTree? {
        return tryInsertAtPosition(present, x, y)
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

fun <T> List<List<T>>.rotateClockwise(): List<List<T>> =
    if (isEmpty()) this
    else List(first().size) { x -> List(size) { y -> get(size - 1 - y)[x] } }

fun <T> List<List<T>>.flipHorizontal(): List<List<T>> = map { it.reversed() }

private fun generateAllSymmetries(shape: List<List<PresentShapeCell>>): List<List<List<PresentShapeCell>>> {
    val rotations = generateSequence(shape) { it.rotateClockwise() }.take(4)
    val flippedRotations = generateSequence(shape.flipHorizontal()) { it.rotateClockwise() }.take(4)
    return (rotations + flippedRotations).distinct().toList()
}

private fun canFitAllPresentsRecursive(currentRegion: RegionUnderTree, remainingPresents: List<PresentPuzzleInput>, symmetriesCache: Map<PresentPuzzleInput, List<List<List<PresentShapeCell>>>>): Boolean {
    if (remainingPresents.isEmpty()) {
        return true
    }

    val currentPresentInput = remainingPresents.first()
    val presentSymmetries = symmetriesCache[currentPresentInput]
        ?: generateAllSymmetries(currentPresentInput.units)

    return (0 until currentRegion.height).any { y ->
        (0 until currentRegion.width).any { x ->
            presentSymmetries.any { shapeRotation ->
                val nextRegion = currentRegion.withPresentInserted(shapeRotation, x, y)
                nextRegion != null && canFitAllPresentsRecursive(nextRegion, remainingPresents.drop(1), symmetriesCache)
            }
        }
    }
}

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
            .sortedByDescending { it.units.sumOf { row -> row.count { cell -> cell == PART_OF_SHAPE } } }

        val presentSymmetriesCache = mutableMapOf<PresentPuzzleInput, List<List<List<PresentShapeCell>>>>()
        presentPuzzleInputs.forEach { presentInput ->
            presentSymmetriesCache[presentInput] = generateAllSymmetries(presentInput.units)
        }

        canFitAllPresentsRecursive(
            RegionUnderTree(regionInput.width, regionInput.height),
            regionsPuzzleInputs,
            presentSymmetriesCache
        )
    }
}