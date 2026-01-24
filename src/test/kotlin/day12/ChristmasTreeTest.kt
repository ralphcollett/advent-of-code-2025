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

        assertEquals(
            listOf(
                listOf(EMPTY, EMPTY),
                listOf(EMPTY, EMPTY),
                listOf(EMPTY, EMPTY)
            ), units
        )
    }

    @Test
    fun `Can put a present in a region when space`() {
        val present = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val regionWithPresent = RegionUnderTree(4, 3).findAllPossibleInsertions(present)

        assertEquals(
            listOf(
                listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE, EMPTY),
                listOf(PART_OF_SHAPE, EMPTY, EMPTY, EMPTY),
                listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE, EMPTY)
            ), regionWithPresent.first().units
        )
    }

    @Test
    fun `Knows when cannot insert shape when not enough space`() {
        val present = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val regionWithPresent = RegionUnderTree(3, 3)
            .findAllPossibleInsertions(present)
            .first()
            .findAllPossibleInsertions(present)

        assertEquals(0, regionWithPresent.size)
    }

    @Test
    fun `Knows when cannot insert shape because too large`() {
        val present = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val regionWithPresent = RegionUnderTree(2, 2).findAllPossibleInsertions(present)

        assertEquals(0, regionWithPresent.size)
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

        val regionWithPresent = RegionUnderTree(4, 2).findAllPossibleInsertions(present1).first().findAllPossibleInsertions(present2)

        assertEquals(
            listOf(
                listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE, EMPTY),
                listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
            ), regionWithPresent.first().units
        )
    }

    @Test
    fun `Can rotate a shape to insert`() {
        val present = listOf(
            listOf(PART_OF_SHAPE, PART_OF_SHAPE),
            listOf(PART_OF_SHAPE, EMPTY),
            listOf(PART_OF_SHAPE, PART_OF_SHAPE)
        )

        val regionWithPresent = RegionUnderTree(3, 2).findAllPossibleInsertions(present)

        assertEquals(
            listOf(
                listOf(PART_OF_SHAPE, PART_OF_SHAPE, PART_OF_SHAPE),
                listOf(PART_OF_SHAPE, EMPTY, PART_OF_SHAPE),
            ), regionWithPresent.first().units
        )
    }

    @Test
    fun `Can get all shape insertions`() {
        val present = listOf(
            listOf(PART_OF_SHAPE, EMPTY),
        )

        val regionWithPresent = RegionUnderTree(2, 1).findAllPossibleInsertions(present)

        assertEquals(
            listOf(
                listOf(
                    listOf(PART_OF_SHAPE, EMPTY)
                ), listOf(
                    listOf(EMPTY, PART_OF_SHAPE)
                )
            ), regionWithPresent.map { it.units })
    }
}