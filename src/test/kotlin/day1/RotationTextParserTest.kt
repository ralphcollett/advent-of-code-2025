package day1

import day1.Direction.LEFT
import day1.Direction.RIGHT
import kotlin.test.Test
import kotlin.test.assertEquals

class RotationTextParserTest {

    @Test
    fun `Parse a left rotation`() {
        assertEquals(listOf(Rotation(LEFT, 68)), parse("L68"))
    }

    @Test
    fun `Parse a right rotation`() {
        assertEquals(listOf(Rotation(RIGHT, 14)), parse("R14"))
    }

    @Test
    fun `Parse multiple rotations`() {
        val actual = parse(
            """
            L68
            L30
            R48
            L5
        """.trimIndent()
        )
        assertEquals(listOf(
            Rotation(LEFT, 68),
            Rotation(LEFT, 30),
            Rotation(RIGHT, 48),
            Rotation(LEFT, 5),
        ), actual)
    }

    @Test
    fun `Ignores invalid rotations`() {
        val actual = parse(
            """
            L68
            l10
            r41
            C25
            L??
             R24
        """.trimIndent()
        )

        assertEquals(listOf(Rotation(LEFT, 68)), actual)
    }
}