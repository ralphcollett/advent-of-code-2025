package day9

import kotlin.test.Test
import kotlin.test.assertEquals


class MovieTheaterAcceptanceTest {
    
    @Test
    fun `Finds biggest rectangle with red tiles for corners`() {
        val puzzleInput = """
            7,1
            11,1
            11,7
            9,7
            9,5
            2,5
            2,3
            7,3
        """.trimIndent()

        val area = findLargestRectangle(puzzleInput)

        assertEquals(50, area)
    }
}