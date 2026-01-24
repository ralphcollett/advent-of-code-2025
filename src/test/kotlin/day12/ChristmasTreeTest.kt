package day12

import day12.PresentShapeCell.EMPTY
import day12.PresentShapeCell.PART_OF_SHAPE
import kotlin.test.Test
import kotlin.test.assertEquals

class ChristmasTreeTest {

    @Test
    fun `Region under tree empty when constructed`() {
        val regionUnderTree = RegionUnderTree(2, 3)

        val units = regionUnderTree.units

        assertEquals(listOf(
            listOf(EMPTY, EMPTY),
            listOf(EMPTY, EMPTY),
            listOf(EMPTY, EMPTY)
        ), units)
    }

    @Test
    fun `Can put a present in a region when space`() {
        val presentShape = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val region = RegionUnderTree(4, 4)

    }
}