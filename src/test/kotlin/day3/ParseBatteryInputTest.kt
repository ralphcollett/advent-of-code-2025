package day3

import kotlin.test.Test
import kotlin.test.assertEquals

class ParseBatteryInputTest {

    data class Bank(val batteries: List<Int>)

    @Test
    fun `Parses the puzzle input`() {
        assertEquals(
            listOf(
                Bank(listOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1))
            ),
            parse("987654321111111")
        )
    }

    private fun parse(puzzleInput: String): List<Bank> {
        return listOf(
            Bank(puzzleInput.map { it.digitToInt() })
        )
    }
}