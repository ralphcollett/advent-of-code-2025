package day7

import day7.TachylonManifoldCell.*
import kotlin.test.Test
import kotlin.test.assertEquals

class TachylonManifoldTest {

    @Test
    fun `Can move Tachylon Beam down from first row to empty`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM_START_POSITION, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY)
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM_START_POSITION, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, EMPTY)
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    @Test
    fun `Can move Tachylon Beam down and split`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM_START_POSITION, EMPTY),
                listOf(EMPTY, SPLITTER, EMPTY)
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM_START_POSITION, EMPTY),
                listOf(TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM)
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    @Test
    fun `Test can split from second row`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM_START_POSITION, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(EMPTY, SPLITTER, EMPTY)
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM_START_POSITION, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM),
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    private fun moveDown(initial: TachylonManifold): TachylonManifold {
        val grid = initial.grid
        val tachylonBeamCellTypes = setOf(TACHYLON_BEAM, TACHYLON_BEAM_START_POSITION)
        val liveRowIndex = grid.indexOfLast { row -> row.any { it in tachylonBeamCellTypes } }
        val liveRow = grid[liveRowIndex]
        val tachylonPosition = liveRow.indexOfLast { it in tachylonBeamCellTypes}
        val nextRow = grid[liveRowIndex + 1]
        val indexNextRow = nextRow.withIndex()
        val nextRowSplitterPositions = indexNextRow.filter { it.value == SPLITTER }.map { it.index }
        val newNextRow = nextRow.mapIndexed { index, cell ->
            when (cell) {
                EMPTY if (index == tachylonPosition) -> TACHYLON_BEAM
                EMPTY if nextRowSplitterPositions.contains(index + 1) -> TACHYLON_BEAM
                EMPTY if nextRowSplitterPositions.contains(index - 1) -> TACHYLON_BEAM
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
}