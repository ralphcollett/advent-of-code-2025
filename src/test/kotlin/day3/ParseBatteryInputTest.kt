package day3

import kotlin.test.Test
import kotlin.test.assertEquals

class ParseBatteryInputTest {

    @Test
    fun `Parses the puzzle input`() {
        assertEquals(
            listOf(
                Bank(listOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)),
                Bank(listOf(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9)),
                Bank(listOf(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)),
                Bank(listOf(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1)),
            ),
            parse("""
                987654321111111
                811111111111119
                234234234234278
                818181911112111
            """.trimIndent())
        )
    }
    
    @Test
    fun `Ignores invalid characters in bank`() {
        assertEquals(
            listOf(
                Bank(listOf(1, 2, 3, 3, 2, 1, 4, 5, 6))
            ), parse("1230321 ??abc000456")
        )
    }

}