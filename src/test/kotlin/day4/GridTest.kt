package day4

import day4.GridCellContents.EMPTY
import day4.GridCellContents.ROLL_OF_PAPER
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

    private fun fewerThanFourRollNeighbours(grid: Grid, rollColumnIndex: Int, rollRowIndex: Int): Boolean {
        val rollNeighours = (rollRowIndex - 1..rollRowIndex + 1).sumOf { rowIndex ->
            (rollColumnIndex - 1..rollColumnIndex + 1).count { columnIndex ->
                val notRollCell = !(rowIndex == rollRowIndex && columnIndex == rollColumnIndex)
                val neighbourIsRollOfPaper = grid.getOrNull(rowIndex)?.getOrNull(columnIndex) == ROLL_OF_PAPER
                notRollCell && neighbourIsRollOfPaper
            }
        }
        return rollNeighours < 4
    }

    private fun accessibleRollsOfPaper(grid: Grid): Int {
        return grid.mapIndexed { rowIndex, row ->
            row.mapIndexed { columnIndex , cellContents ->
                when {
                    cellContents == EMPTY -> 0
                    fewerThanFourRollNeighbours(grid, columnIndex, rowIndex) -> 1
                    else -> 0
                }
            }
        }.sumOf { it.sum() }
    }
}