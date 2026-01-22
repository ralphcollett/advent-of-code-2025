package day6

import day6.CephalodMathOperator.ADDITION
import day6.CephalodMathOperator.MULTIPLICATION
import kotlin.test.Test
import kotlin.test.assertEquals

class CephalodMathInputParserTest {

    @Test
    fun `Parses maths input`() {
        val puzzleInput = """
            123 328  51 64 
             45 64  387 23 
              6 98  215 314
            *   +   *   +   
        """.trimIndent()

        assertEquals(
            CephalodMath(
                listOf(
                    CephalodMathProblem(listOf(123, 45, 6), MULTIPLICATION),
                    CephalodMathProblem(listOf(328, 64, 98), ADDITION),
                    CephalodMathProblem(listOf(51, 387, 215), MULTIPLICATION),
                    CephalodMathProblem(listOf(64, 23, 314), ADDITION)
                )
            ), parse(puzzleInput)
        )
    }

    @Test
    fun `Ignores incomplete columns`() {
        val puzzleInput = """
            123 328  51 64 
             45 64  387 
              6 98  215 314
            *   +   *   +   
        """.trimIndent()

        assertEquals(
            CephalodMath(
                listOf(
                    CephalodMathProblem(listOf(123, 45, 6), MULTIPLICATION),
                    CephalodMathProblem(listOf(328, 64, 98), ADDITION),
                    CephalodMathProblem(listOf(51, 387, 215), MULTIPLICATION),
                )
            ), parse(puzzleInput)
        )
    }

    @Test
    fun `Ignores columns with invalid operators`() {
        val puzzleInput = """
            123 328 
             45 64  
              6 98 
            *   ?     
        """.trimIndent()

        assertEquals(
            CephalodMath(
                listOf(
                    CephalodMathProblem(listOf(123, 45, 6), MULTIPLICATION),
                )
            ), parse(puzzleInput)
        )
    }

    @Test
    fun `Ignores columns with invalid numbers`() {
        val puzzleInput = """
            123 328 
             45 ABC  
              6 98 
            *   +   
        """.trimIndent()

        assertEquals(
            CephalodMath(
                listOf(
                    CephalodMathProblem(listOf(123, 45, 6), MULTIPLICATION),
                )
            ), parse(puzzleInput)
        )
    }

}