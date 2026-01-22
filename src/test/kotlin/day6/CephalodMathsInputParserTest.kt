package day6

import day6.CephalodMathsOperator.MULTIPLIED
import kotlin.test.Test
import kotlin.test.assertEquals

enum class CephalodMathsOperator {
    PLUS, MULTIPLIED
}

data class CephalodMathsProblem(val numbers: List<Int>, val operator: CephalodMathsOperator)

data class CephalodMaths(val problems: List<CephalodMathsProblem>)

class CephalodMathsInputParserTest {

    @Test
    fun `Parses maths input`() {
        val puzzleInput = """
            123
             45
              6
            *  
        """.trimIndent()

        assertEquals(
            CephalodMaths(
                listOf(
                    CephalodMathsProblem(
                        listOf(123, 45, 6),
                        MULTIPLIED
                    )
                )
            ), parse(puzzleInput)
        )
    }

    private fun parse(puzzleInput: String): CephalodMaths {
        val numbersInput = puzzleInput.split("\n").dropLast(1)
        return CephalodMaths(
            listOf(
                CephalodMathsProblem(
                    numbersInput.map { it.trim().toInt() },
                    MULTIPLIED
                )
            )
        )
    }
}