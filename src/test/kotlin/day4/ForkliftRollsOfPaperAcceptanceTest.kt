package day4

import kotlin.test.Test
import kotlin.test.assertEquals

class ForkliftRollsOfPaperAcceptanceTest {

    @Test
    fun `Knows how many rolls of paper can be accessed by a forklift`() {
        val puzzleInput = """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
        """.trimIndent()

        assertEquals(13, rollsOfPaperAccessibleByForklift(puzzleInput))
    }

}