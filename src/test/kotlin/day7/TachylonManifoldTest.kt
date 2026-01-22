package day7

import day7.TachylonManifoldCell.*
import kotlin.test.Test
import kotlin.test.assertEquals

class TachylonManifoldTest {

    @Test
    fun `Can move Tachylon Beam down from first row to empty`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY)
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, EMPTY)
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    @Test
    fun `Can move Tachylon Beam down and split`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(EMPTY, SPLITTER, EMPTY)
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM)
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    @Test
    fun `Test can split from second row`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(EMPTY, SPLITTER, EMPTY)
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, EMPTY),
                listOf(TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM),
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    @Test
    fun `Can deal with multiple splitters`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, EMPTY, TACHYLON_BEAM, EMPTY, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, EMPTY),
                listOf(EMPTY, SPLITTER, EMPTY, SPLITTER, EMPTY),
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, EMPTY, TACHYLON_BEAM, EMPTY, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, EMPTY),
                listOf(TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM),
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    @Test
    fun `No change when all beams reach a splitter`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, EMPTY, TACHYLON_BEAM, EMPTY, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, EMPTY),
                listOf(SPLITTER, SPLITTER, SPLITTER, SPLITTER, SPLITTER),
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, EMPTY, TACHYLON_BEAM, EMPTY, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, EMPTY),
                listOf(SPLITTER, SPLITTER, SPLITTER, SPLITTER, SPLITTER),
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    @Test
    fun `No change when beams exit manifold`() {
        val initial = TachylonManifold(
            listOf(
                listOf(EMPTY, EMPTY, TACHYLON_BEAM, EMPTY, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, EMPTY),
            )
        )

        val moved = TachylonManifold(
            listOf(
                listOf(EMPTY, EMPTY, TACHYLON_BEAM, EMPTY, EMPTY),
                listOf(EMPTY, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, EMPTY),
            )
        )

        assertEquals(moved, moveDown(initial))
    }

    private fun moveDown(initial: TachylonManifold): TachylonManifold {
        val grid = initial.grid
        val liveRowIndex = grid.indexOfLast { row -> row.any { it == TACHYLON_BEAM } }
        val liveRow = grid[liveRowIndex]
        val tachylonPositions = liveRow.withIndex().filter { it.value == TACHYLON_BEAM }.map { it.index }
        val nextRow = grid.getOrNull(liveRowIndex + 1) ?: return initial
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
}