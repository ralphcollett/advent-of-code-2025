package day7

import day7.TachylonManifoldInputParserTest.TachylonManifoldCell.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TachylonManifoldInputParserTest {

    enum class TachylonManifoldCell {
        SPLITTER, EMPTY, TACHYLON_BEAM
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
                listOf(EMPTY, EMPTY, EMPTY, TACHYLON_BEAM, EMPTY, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY, SPLITTER, EMPTY, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, SPLITTER, EMPTY, SPLITTER, EMPTY, EMPTY),
                listOf(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY),
            )
        )

        assertEquals(tachylonManifold, parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): TachylonManifold {
        val cells = puzzleInput.split("\n").map { rowInput ->
            rowInput.map {
                when (it) {
                    'S' -> TACHYLON_BEAM
                    '^' -> SPLITTER
                    else -> EMPTY
                }
            }
        }
        return TachylonManifold(cells)
    }
}