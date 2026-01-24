package day11

import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class ReactorAcceptanceTest {

    @Test
    @Ignore
    fun `Counts paths from you to out`() {
        val puzzleInput = """
            aaa: you hhh
            you: bbb ccc
            bbb: ddd eee
            ccc: ddd eee fff
            ddd: ggg
            eee: out
            fff: out
            ggg: out
            hhh: ccc fff iii
            iii: out
        """.trimIndent()


        assertEquals(5, pathsFromYouToOut(puzzleInput))
    }

}