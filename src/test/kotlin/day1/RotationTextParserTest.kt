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
}