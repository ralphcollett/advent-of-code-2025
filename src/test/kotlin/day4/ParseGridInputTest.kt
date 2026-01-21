package day4

import day4.GridCellContents.EMPTY
import day4.GridCellContents.ROLL_OF_PAPER
import kotlin.test.Test
import kotlin.test.assertEquals

class ParseGridInputTest {

    @Test
    fun `Grid input parsed correctly`() {
        val grid = listOf(
            listOf(EMPTY, ROLL_OF_PAPER, ROLL_OF_PAPER),
            listOf(ROLL_OF_PAPER, ROLL_OF_PAPER, ROLL_OF_PAPER),
            listOf(EMPTY, ROLL_OF_PAPER, ROLL_OF_PAPER)
        )

        val puzzleInput = """
            .@@
            @@@
            .@@
        """.trimIndent()

        assertEquals(grid, parse(puzzleInput))
    }

    @Test
    fun `Ignores grid with invalid input`() {
        val puzzleInput = """
            .@?
            @-@
            .@@
        """.trimIndent()

        assertEquals(emptyList(), parse(puzzleInput))
    }

    @Test
    fun `Crops to shortest column`() {
        @Test
        fun `Grid input parsed correctly`() {
            val grid = listOf(
                listOf(EMPTY, ROLL_OF_PAPER),
                listOf(ROLL_OF_PAPER, ROLL_OF_PAPER)
            )

            val puzzleInput = """
            .@@
            @@ 
        """.trimIndent()

            assertEquals(grid, parse(puzzleInput))
        }
    }

    private fun parse(puzzleInput: String): Grid {
        val rows = puzzleInput.split("\n")
        val longestRowLength = rows.maxOf { it.length }
        return rows.take(longestRowLength).map { row ->
            row.map {
                when (it) {
                    '.' -> EMPTY
                    '@' -> ROLL_OF_PAPER
                    else -> return emptyList()
                }
            }
        }
    }
}