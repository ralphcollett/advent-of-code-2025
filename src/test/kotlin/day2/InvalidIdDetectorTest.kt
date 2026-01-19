package day2

import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test

class InvalidIdDetectorTest {

    @Test
    fun `Knows if ID invalid`() {
        assertTrue(idInvalid(11))
    }

    private fun idInvalid(productID: Int): Boolean {
        return true
    }
}