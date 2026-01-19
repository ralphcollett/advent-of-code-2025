package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class InvalidIdRangeTest {

    @Test
    fun `Finds invalid IDs in a range`() {
        assertEquals(listOf(11, 22), findInvalidIds(IdRange(11, 22)))
    }
}

