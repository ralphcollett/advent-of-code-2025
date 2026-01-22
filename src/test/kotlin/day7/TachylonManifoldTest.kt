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

    private fun moveDown(initial: TachylonManifold): TachylonManifold {
        val grid = initial.grid
        val topRow = grid.first()
        val tachylonStartPosition = topRow.indexOf(TACHYLON_BEAM_START_POSITION)
        val secondRow = grid[1]
        val indexedSecondRow = secondRow.withIndex()
        val secondRowSplitterPositions = indexedSecondRow.filter { it.value == SPLITTER }.map { it.index }
        val newSecondRow = secondRow.mapIndexed { index, cell ->
            when (cell) {
                EMPTY if (index == tachylonStartPosition) -> TACHYLON_BEAM
                EMPTY if secondRowSplitterPositions.contains(index + 1) -> TACHYLON_BEAM
                EMPTY if secondRowSplitterPositions.contains(index - 1) -> TACHYLON_BEAM
                SPLITTER -> SPLITTER
                else -> EMPTY
            }
        }
        return TachylonManifold(
            listOf(topRow, newSecondRow)
        )
    }
}