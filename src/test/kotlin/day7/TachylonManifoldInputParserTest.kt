package day7

import day7.TachylonManifoldInputParserTest.TachylonManifoldCell.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TachylonManifoldInputParserTest {

    enum class TachylonManifoldCell {
        SPLITTER, EMPTY, TACHYLON_BEAM_START_POSITION
    }

    data class TachylonManifold(val cells: List<List<TachylonManifoldCell>>)

    @Test
    fun `Parses input`() {
        val puzzleInput = """
            ...S...
            .......
            ...^...
            .......
            ..^.^..
            .......
        """.trimIndent()

        val tachylonManifold = TachylonManifold(
            listOf(
                listOf(EMPTY, EMPTY, EMPTY, TACHYLON_BEAM_START_POSITION, EMPTY, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY, SPLITTER, EMPTY, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, SPLITTER, EMPTY, SPLITTER, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY),
            )
        )

        assertEquals(tachylonManifold, parse(puzzleInput))
    }

    @Test
    fun `Top row must have a S`() {
        val puzzleInput = """
            .......
            .......
        """.trimIndent()

        assertNull(parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): TachylonManifold? {
        val cells = puzzleInput.split("\n").map { rowInput ->
            rowInput.map {
                when (it) {
                    'S' -> TACHYLON_BEAM_START_POSITION
                    '^' -> SPLITTER
                    else -> EMPTY
                }
            }
        }
        if (! cells.first().contains(TACHYLON_BEAM_START_POSITION)) return null
        return TachylonManifold(cells)
    }
}