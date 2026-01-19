package day1

import day1.Direction.LEFT
import kotlin.test.Test
import kotlin.test.assertEquals

class RotationTextParserTest {

    @Test
    fun `Parse a left rotation`() {
        assertEquals(Rotation(LEFT, 68), parse("L68"))
    }
}