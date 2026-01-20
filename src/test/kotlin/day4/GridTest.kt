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

        assertEquals(0, rollsOfPaper(grid))
    }

    private fun rollsOfPaper(grid: Grid): Int {
        return 0
    }
}