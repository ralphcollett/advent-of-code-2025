package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class InvalidIdRangeTextParserTest {

    @Test
    fun `Parses a range`() {
        assertEquals(listOf(IdRange(11, 22)), parse("11-22"))
    }

    @Test
    fun `Parses multiple ranges`() {
        val ranges = parse(
            """
            11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
            1698522-1698528,446443-446449,38593856-38593862,565653-565659,
            824824821-824824827,2121212118-2121212124
        """.trimIndent()
        )

        assertEquals(listOf(
            IdRange(11, 22),
            IdRange(95, 115),
            IdRange(998, 1012),
            IdRange(1188511880, 1188511890),
            IdRange(222220, 222224),
            IdRange(1698522, 1698528),
            IdRange(446443, 446449),
            IdRange(38593856, 38593862),
            IdRange(565653, 565659),
            IdRange(824824821, 824824827),
            IdRange(2121212118, 2121212124),
        ), ranges)
    }

}