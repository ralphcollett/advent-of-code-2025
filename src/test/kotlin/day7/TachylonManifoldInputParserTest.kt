package day7

import day7.TachylonManifoldCell.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TachylonManifoldInputParserTest {

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

    @Test
    fun `Top row must have a starting position`() {
        val puzzleInput = """
            .......
            .......
        """.trimIndent()

        assertNull(parse(puzzleInput))
    }

    @Test
    fun `Must not contain invalid characters`() {
        val puzzleInput = """
            ...S...
            ...?.x.
        """.trimIndent()

        assertNull(parse(puzzleInput))
    }

    @Test
    fun `Rows must be same length`() {
        val puzzleInput = """
            ...S...
            .....
            ........
        """.trimIndent()

        assertNull(parse(puzzleInput))
    }

    @Test
    fun `Not allow an empty grid`() {
        assertNull(parse(""))
    }

}