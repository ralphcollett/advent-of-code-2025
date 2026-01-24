package day10

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class FactoryAcceptanceTest {

    @Test
    fun `Find minimum presses to correctly configure indicator lights`() {
        val puzzleInput = """
            [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
            [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
            [.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}
        """.trimIndent()

        val presses = minimumButtonPresses(puzzleInput)

        assertEquals(7, presses)
    }

    @Test
    fun `Null if no button preses possible for some machines`() {
        val puzzleInput = """
            [.##.] (3) (1,3) (0,1) {3,5,4,7}
            [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
        """.trimIndent() // machine on top rows light diagram cannot be matches

        val presses = minimumButtonPresses(puzzleInput)

        assertNull(presses)
    }
}