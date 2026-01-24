package day12

import day12.ChristmasTreePuzzleInputParserTest.PresentShapeCell.EMPTY
import day12.ChristmasTreePuzzleInputParserTest.PresentShapeCell.PART_OF_SHAPE
import kotlin.test.Test
import kotlin.test.assertEquals

class ChristmasTreePuzzleInputParserTest {

    enum class PresentShapeCell {
        PART_OF_SHAPE, EMPTY
    }

    data class Present(val index: Int, val shape: List<List<PresentShapeCell>>)

    data class RegionUnderTree(val width: Int, val height: Int, val quantityOfPresents: List<Int>)

    data class ChristmasTreePuzzleInput(val presents: List<Present>, val regions: List<RegionUnderTree>)

    @Test
    fun `Parses input`() {
        val puzzleInput = """
            0:
            ###
            ##.
            ##.

            1:
            ###
            ##.
            .##

            4x4: 0 2
            12x5: 1 0
        """.trimIndent()

        val actual = parse(puzzleInput)

        val expected = ChristmasTreePuzzleInput(
            listOf(
                Present(
                    0, listOf(
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, EMPTY),
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, EMPTY)
                    )
                ), Present(
                    1, listOf(
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, EMPTY),
                        listOf(EMPTY, PART_OF_SHAPE, PART_OF_SHAPE)
                    )
                )
            ),
            listOf(
                RegionUnderTree(width = 4, height = 4, listOf(0, 2)),
                RegionUnderTree(width = 12, height = 5, listOf(1, 0))
            )
        )

        assertEquals(expected, actual)
    }

    private fun parse(puzzleInput: String): ChristmasTreePuzzleInput {
        val presentsInputSection = puzzleInput.substringBeforeLast("\n\n").split("\n\n")
        val presents = presentsInputSection.map { presentInputSection ->
            val presentIndexRow = presentInputSection.substringBefore("\n")
            val presentIndex = presentIndexRow.substringBefore(":").toInt()
            val presentShapeRows = presentInputSection.substringAfter("\n").split("\n")
            val shape = presentShapeRows.map { presentShapeRow ->
                presentShapeRow.map { presentShapeCell ->
                    when (presentShapeCell) {
                        '#' -> PART_OF_SHAPE
                        else -> EMPTY
                    }

                }
            }
            Present(presentIndex, shape)
        }

        val regionsInputSection = puzzleInput.substringAfterLast("\n\n")
        val regionsUnderTree = regionsInputSection.split("\n").map { regionInputSection ->
            val (width, height) = regionInputSection.substringBefore(":").split("x").map { it.toInt() }
            val quantityOfPresents = regionInputSection.substringAfter(" ").split(" ").map { it.toInt() }
            RegionUnderTree(width, height, quantityOfPresents)
        }

        return ChristmasTreePuzzleInput(presents, regionsUnderTree)
    }
}