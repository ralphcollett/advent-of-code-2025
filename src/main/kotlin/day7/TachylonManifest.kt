package day7

import day7.TachylonManifoldCell.*

enum class TachylonManifoldCell {
    SPLITTER, EMPTY, TACHYLON_BEAM
}

data class TachylonManifold(val grid: List<List<TachylonManifoldCell>>)

fun TachylonManifold.moveDown(): TachylonManifold {
    val grid = grid
    val liveRowIndex = grid.indexOfLast { row -> row.any { it == TACHYLON_BEAM } }
    val liveRow = grid[liveRowIndex]
    val tachylonPositions = liveRow.withIndex().filter { it.value == TACHYLON_BEAM }.map { it.index }
    val nextRow = grid.getOrNull(liveRowIndex + 1) ?: return this
    val indexNextRow = nextRow.withIndex()
    val nextRowSplitterPositions = indexNextRow.filter { it.value == SPLITTER }.map { it.index }
    val newNextRow = nextRow.mapIndexed { index, cell ->
        when (cell) {
            EMPTY if (index in tachylonPositions) -> TACHYLON_BEAM
            EMPTY if (index + 1 in tachylonPositions) && index + 1 in nextRowSplitterPositions -> TACHYLON_BEAM
            EMPTY if (index - 1 in tachylonPositions) && index - 1 in nextRowSplitterPositions -> TACHYLON_BEAM
            SPLITTER -> SPLITTER
            else -> EMPTY
        }
    }
    val newGrid = grid.mapIndexed { index, row ->
        when (index) {
            liveRowIndex + 1 -> newNextRow
            else -> row
        }
    }
    return TachylonManifold(newGrid)
}

fun TachylonManifold.splits(): Int {
    return grid.takeWhile { it.contains(TACHYLON_BEAM) }.mapIndexed { rowNumber, row ->
        when {
            rowNumber >= grid.size - 1 -> 0
            else -> row.zip(grid[rowNumber + 1]).count { (currentRowCell, nextRowCell) ->
                currentRowCell == TACHYLON_BEAM && nextRowCell == SPLITTER
            }
        }
    }.sum()
}


