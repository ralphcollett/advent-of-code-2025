package day2

import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test
import kotlin.test.assertFalse

class InvalidIdDetectorTest {

    @Test
    fun `Knows if ID invalid 2 digit number`() {
        assertTrue(idInvalid(11))
        assertTrue(idInvalid(99))
    }

    @Test
    fun `Knows if ID invalid 4 digit number`() {
        assertTrue(idInvalid(1010))
    }

    @Test
    fun `Knows if ID invalid for many digits`() {
        assertTrue(idInvalid(1188511885))
        assertTrue(idInvalid(222222))
    }

    @Test
    fun `Knows if valid`() {
        assertFalse(idInvalid(12))
    }

}