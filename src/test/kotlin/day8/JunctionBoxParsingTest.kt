package day8

import kotlin.test.Test
import kotlin.test.assertEquals

class JunctionBoxParsingTest {

    data class JunctionBox(val x: Int, val y: Int, val z: Int)

    @Test
    fun `Parses a Junction Box from puzzle input`() {
        val puzzleInput = """
            162,817,812
            57,618,57
            906,360,560
            592,479,940
        """.trimIndent()

        val expected = listOf(
            JunctionBox(162, 817, 812),
            JunctionBox(57, 618, 57),
            JunctionBox(906, 360, 560),
            JunctionBox(592, 479, 940),
        )

        assertEquals(expected, parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): List<JunctionBox> {
        return puzzleInput.split("\n").map { row ->
            row.split(",").let { (x, y, z) ->
                JunctionBox(x.toInt(), y.toInt(), z.toInt())
            }
        }
    }
}