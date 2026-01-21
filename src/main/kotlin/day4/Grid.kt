package day4

import day4.GridCellContents.EMPTY
import day4.GridCellContents.ROLL_OF_PAPER

enum class GridCellContents {
    ROLL_OF_PAPER, EMPTY
}

typealias Grid = Array<Array<GridCellContents>>

fun accessibleRollsOfPaper(grid: Grid): Int {
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
