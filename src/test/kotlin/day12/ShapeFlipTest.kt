package day12

import day12.PresentShapeCell.EMPTY
import day12.PresentShapeCell.PART_OF_SHAPE
import kotlin.test.Test
import kotlin.test.assertEquals

class ShapeFlipTest {

    @Test
    fun `Can flip a present`() {
        val rotated = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE)
        ).flipHorizontal()

        val expected = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(EMPTY, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE)
        )

        assertEquals(expected, rotated)
    }

    @Test
    fun `Can flip twice`() {
        val rotated = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE)
        ).flipHorizontal().flipHorizontal()

        val expected = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE)
        )

        assertEquals(expected, rotated)
    }

    @Test
    fun `Flip empty`() {
        assertEquals(emptyList(), emptyList<List<Int>>().flipHorizontal())
    }
}
