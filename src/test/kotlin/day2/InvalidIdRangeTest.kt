package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class InvalidIdRangeTest {

    @Test
    fun `Finds invalid IDs in a range`() {
        assertEquals(listOf(11, 22), findInvalidIds(IdRange(11, 22)))
    }

    private fun findInvalidIds(range: IdRange): List<Int> {
        return (range.firstId ..range.secondIdRange).filter { idInvalid(it) }
    }
}

data class IdRange(val firstId: Int, val secondIdRange: Int)
