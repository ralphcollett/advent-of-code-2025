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

        assertEquals(moved, initial.moveDown())
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

        assertEquals(moved, initial.moveDown())
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

        assertEquals(moved, initial.moveDown())
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

        assertEquals(moved, initial.moveDown())
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

        assertEquals(moved, initial.moveDown())
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

        assertEquals(moved, initial.moveDown())
    }

    @Test
    fun `Counts splits`() {
        assertEquals(
            3, TachylonManifold(
                listOf(
                    listOf(EMPTY, EMPTY, TACHYLON_BEAM, EMPTY, EMPTY),
                    listOf(EMPTY, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, EMPTY),
                    listOf(TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM, SPLITTER, TACHYLON_BEAM),
                )
            ).splits()
        )
    }
}

private fun TachylonManifold.splits(): Int {
    return grid.takeWhile { it.contains(TACHYLON_BEAM) }.mapIndexed { rowNumber, row ->
        when {
            rowNumber >= grid.size - 1 -> 0
            else -> row.zip(grid[rowNumber + 1]).count { (currentRowCell, nextRowCell) ->
                currentRowCell == TACHYLON_BEAM && nextRowCell == SPLITTER
            }
        }
    }.sum()
}
