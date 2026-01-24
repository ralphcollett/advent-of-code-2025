package day12

import day12.PresentShapeCell.EMPTY
import day12.PresentShapeCell.PART_OF_SHAPE
import kotlin.test.Test
import kotlin.test.assertEquals

class ShapeRotationTest {

    @Test
    fun `Can rotate a present clockwise`() {
        val rotated = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE)
        ).rotateClockwise()

        val expected = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, PART_OF_SHAPE)
        )

        assertEquals(expected, rotated)
    }
}
