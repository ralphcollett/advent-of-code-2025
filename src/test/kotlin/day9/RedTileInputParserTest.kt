package day9

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RedTileInputParserTest {

    data class TileDimensions(val x: Int, val y: Int)

    @Test
    fun `Parses red tile coordinates`() {
        val puzzleInput = """
            7,1
            11,1
            11,7
        """.trimIndent()

        assertEquals(listOf(
            TileDimensions(7, 1),
            TileDimensions(11, 1),
            TileDimensions(11, 7)
        ), parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): List<TileDimensions> {
        return puzzleInput.split("\n").map { row ->
            row.split(",").map { it.toInt() }.let { (x, y) ->
                TileDimensions(x, y)
            }
        }
    }
}