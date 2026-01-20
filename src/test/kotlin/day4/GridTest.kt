package day4

import kotlin.test.Test
import kotlin.test.assertEquals

enum class GridCellContents {
    ROLL_OF_PAPER, EMPTY
}

typealias Grid = Array<Array<GridCellContents>>

class GridTest {
    
    @Test
    fun `Empty grid has no rolls of paper`() {
        val grid = arrayOf<Array<GridCellContents>>(emptyArray())

        assertEquals(0, accessibleRollsOfPaper(grid))
    }
    
    @Test
    fun `If just one roll of paper knows accessible`() {
        val grid = arrayOf(
            arrayOf(GridCellContents.ROLL_OF_PAPER)
        )

        assertEquals(1, accessibleRollsOfPaper(grid))
    }

    private fun accessibleRollsOfPaper(grid: Grid): Int {
        return grid.sumOf { row ->
            row.count { it == GridCellContents.ROLL_OF_PAPER }
        }
    }
}