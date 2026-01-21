package day4

import day4.GridCellContents.EMPTY
import day4.GridCellContents.ROLL_OF_PAPER
import kotlin.test.Test
import kotlin.test.assertEquals

class GridTest {
    
    @Test
    fun `Empty grid has no rolls of paper`() {
        val grid = arrayOf<Array<GridCellContents>>(emptyArray())

        assertEquals(0, accessibleRollsOfPaper(grid))
    }
    
    @Test
    fun `If just one roll of paper knows accessible`() {
        val grid = arrayOf(
            arrayOf(ROLL_OF_PAPER)
        )

        assertEquals(1, accessibleRollsOfPaper(grid))
    }

    @Test
    fun `Roll of paper accessible if surrounded by fewer than 4 adjacent roles`() {
        val grid = arrayOf(
            arrayOf(EMPTY, ROLL_OF_PAPER, ROLL_OF_PAPER), // EMPTY ROLL ACCESSIBLE 1
            arrayOf(ROLL_OF_PAPER, ROLL_OF_PAPER, ROLL_OF_PAPER), // ACCESSIBLE ROLL ROLL 1
            arrayOf(EMPTY, ROLL_OF_PAPER, ROLL_OF_PAPER) // EMPTY ACCESSIBLE ROLL 1
        ) // 1 + 1 + 1 = 3

        assertEquals(3, accessibleRollsOfPaper(grid))
    }
}