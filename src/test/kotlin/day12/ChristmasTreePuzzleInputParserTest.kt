package day12

import day12.PresentShapeCell.EMPTY
import day12.PresentShapeCell.PART_OF_SHAPE
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ChristmasTreePuzzleInputParserTest {

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
                PresentPuzzleInput(
                    0, listOf(
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, EMPTY),
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, EMPTY)
                    )
                ), PresentPuzzleInput(
                    1, listOf(
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
                        listOf(PART_OF_SHAPE, PART_OF_SHAPE, EMPTY),
                        listOf(EMPTY, PART_OF_SHAPE, PART_OF_SHAPE)
                    )
                )
            ),
            listOf(
                RegionUnderTreePuzzleInput(width = 4, height = 4, listOf(0, 2)),
                RegionUnderTreePuzzleInput(width = 12, height = 5, listOf(1, 0))
            )
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `Does not allow invalid characters in present shape input`() {
        val puzzleInput = """
            0:
            ###
            #?.
            ##.

            4x4: 0
        """.trimIndent()

        val actual = parse(puzzleInput)

        assertNull(actual)
    }

    @Test
    fun `Shape rows have same elements in each row`() {
        val puzzleInput = """
            0:
            ####
            ##....
            ##

            4x4: 0
        """.trimIndent()

        val actual = parse(puzzleInput)

        assertNull(actual)
    }

    @Test
    fun `Present indexes should be 0, 1, 2, etc`() {
        val puzzleInput = """
            0:
            ###
            ##.
            ##.

            12:
            ###
            ##.
            .##

            4x4: 0 2
            12x5: 1 0
        """.trimIndent()

        val actual = parse(puzzleInput)

        assertNull(actual)
    }

    @Test
    fun `Should have quantity for each shape`() {
        val puzzleInput = """
            0:
            ###
            ##.
            ##.

            1:
            ###
            ##.
            .##

            4x4: 0
            12x5: 1 0
        """.trimIndent()

        val actual = parse(puzzleInput)

        assertNull(actual)
    }

}