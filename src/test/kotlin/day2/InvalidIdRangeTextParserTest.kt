package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class InvalidIdRangeTextParserTest {

    @Test
    fun `Parses a range`() {
        assertEquals(listOf(IdRange(11, 22)), parse("11-22"))
    }

    private fun parse(inputString: String): List<IdRange> {
        val rangeIds = inputString.split("-")
        return listOf(IdRange(rangeIds[0].toInt(), rangeIds[1].toInt()))
    }
}