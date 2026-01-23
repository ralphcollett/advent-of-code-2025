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

    @Test
    fun `Ignores rows with invalid characters`() {
        val puzzleInput = """
            162,817,812
            A,618,57
            57,B,57
            57,618,C
        """.trimIndent()

        val expected = listOf(
            JunctionBox(162, 817, 812),
        )

        assertEquals(expected, parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): List<JunctionBox> {
        return puzzleInput.split("\n")
            .mapNotNull { row -> row.split(",")
                .mapNotNull { coordinate -> coordinate.toIntOrNull() }
                .takeIf { it.size == 3 }
            }
            .map { (x, y, z) -> JunctionBox(x, y, z) }
    }
}