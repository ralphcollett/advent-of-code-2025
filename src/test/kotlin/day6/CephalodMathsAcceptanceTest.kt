package day6

import org.junit.jupiter.api.Disabled
import kotlin.test.Test
import kotlin.test.assertEquals

class CephalodMathsAcceptanceTest {

    @Test
    @Disabled
    fun `Solves Cephalod math homework`() {
        val puzzleInput = """
            123 328  51 64 
             45 64  387 23 
              6 98  215 314
            *   +   *   +  
        """.trimIndent()

        val grandTotal = solveCephalodMathHomework(puzzleInput)

        assertEquals(4277556, grandTotal)
    }

    private fun solveCephalodMathHomework(puzzleInput: String): Int {
        TODO("Not yet implemented")
    }
}