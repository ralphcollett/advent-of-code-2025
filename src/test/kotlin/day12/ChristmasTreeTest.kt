package day12

import day12.PresentShapeCell.EMPTY
import day12.PresentShapeCell.PART_OF_SHAPE
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

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
        val present = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val regionWithPresent = RegionUnderTree(4, 3).insert(present)

        assertEquals(listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, EMPTY, EMPTY, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE, EMPTY)
        ), regionWithPresent?.units)
    }

    @Test
    fun `Knows when cannot insert shape when not enough space`() {
        val present = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val regionWithPresent = RegionUnderTree(3, 3)
            .insert(present)
            ?.insert(present)

        assertNull(regionWithPresent)
    }

    @Test
    fun `Knows when cannot insert shape because too large`() {
        val present = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val regionWithPresent = RegionUnderTree(2, 2).insert(present)

        assertNull(regionWithPresent)
    }

    @Test
    fun `Inputs a second shape in remaining space`() {
        val present1 = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
        )

        val present2 = listOf(
            listOf(PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
        )

        val regionWithPresent = RegionUnderTree(4, 2).insert(present1)?.insert(present2)

        assertEquals(listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
        ), regionWithPresent?.units)
    }

    @Test
    @Ignore
    fun `Can rotate a shape to insert`() {
        val present = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val regionWithPresent = RegionUnderTree(3, 2).insert(present)

        assertEquals(listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, PART_OF_SHAPE),
        ), regionWithPresent?.units)
    }
}