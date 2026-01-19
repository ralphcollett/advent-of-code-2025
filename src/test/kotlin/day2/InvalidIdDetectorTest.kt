package day2

import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test
import kotlin.test.assertFalse

class InvalidIdDetectorTest {

    @Test
    fun `Knows if ID invalid 2 digit number`() {
        assertTrue(idInvalid(11))
    }

    @Test
    fun `Knows if ID invalid 4 digit number`() {
        assertTrue(idInvalid(1010))
    }

    @Test
    fun `Knows if valid`() {
        assertFalse(idInvalid(12))
    }

    private fun idInvalid(productID: Int): Boolean {
        val digits = generateSequence(productID / 10 to productID % 10)
            { it.first / 10 to it.first % 10 }
            .takeWhile { it.first > 0 || it.second > 0 }
            .map { it.second }
            .toList()
            .reversed()

        val firstHalf = digits.subList(0, digits.size / 2)
        val secondHalf = digits.subList(digits.size / 2, digits.size)
        return firstHalf == secondHalf
    }
}