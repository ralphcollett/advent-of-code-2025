package day9

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RedTileInputParserTest {

    @Test
    fun `Parses red tile coordinates`() {
        val puzzleInput = """
            7,1
            11,1
            11,7
        """.trimIndent()

        assertEquals(listOf(
            Tile(7, 1),
            Tile(11, 1),
            Tile(11, 7)
        ), parse(puzzleInput))
    }

    @Test
    fun `Ignores invalid coordinates`() {
        val puzzleInput = """
            7,1
            9,1,12
            x,1
            11,y
            23
        """.trimIndent()

        assertEquals(listOf(
            Tile(7, 1),
        ), parse(puzzleInput))
    }

}