package day2

import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test
import kotlin.test.assertFalse

class InvalidIdDetectorTest {

    @Test
    fun `Knows if ID invalid`() {
        assertTrue(idInvalid(11))
    }

    @Test
    fun `Knows if valid`() {
        assertFalse(idInvalid(12))
    }

    private fun idInvalid(productID: Int): Boolean {
        return productID % 10 == productID / 10
    }
}