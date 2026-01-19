package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class InvalidIdRangeTest {

    @Test
    fun `Finds invalid IDs in a range`() {
        assertEquals(listOf(11, 22), findInvalidIds(IdRange(11, 22)))
        assertEquals(listOf(1188511885), findInvalidIds(IdRange(1188511880, 1188511890)))
        assertEquals(emptyList(), findInvalidIds(IdRange(1698522, 1698528)))
    }
}

