package day6

import day6.CephalodMathsOperator.ADDITION
import day6.CephalodMathsOperator.MULTIPLICATION
import kotlin.test.Test
import kotlin.test.assertEquals

enum class CephalodMathsOperator {
    ADDITION, MULTIPLICATION
}

data class CephalodMathsProblem(val numbers: List<Int>, val operator: CephalodMathsOperator)

data class CephalodMaths(val problems: List<CephalodMathsProblem>)

class CephalodMathsInputParserTest {

    @Test
    fun `Parses maths input`() {
        val puzzleInput = """
            123 328  51 64 
             45 64  387 23 
              6 98  215 314
            *   +   *   +   
        """.trimIndent()

        assertEquals(
            CephalodMaths(
                listOf(
                    CephalodMathsProblem(listOf(123, 45, 6), MULTIPLICATION),
                    CephalodMathsProblem(listOf(328, 64, 98), ADDITION),
                    CephalodMathsProblem(listOf(51, 387, 215), MULTIPLICATION),
                    CephalodMathsProblem(listOf(64, 23, 314), ADDITION)
                )
            ), parse(puzzleInput)
        )
    }

    private fun parse(puzzleInput: String): CephalodMaths {
        val puzzleInputRows = puzzleInput.split("\n")
        val numberInputRows = puzzleInputRows.dropLast(1).map { it.trim().split("\\s+".toRegex()) }
        val operators = puzzleInputRows.last().split("\\s+".toRegex()).map {
            when (it) {
                "*" -> MULTIPLICATION
                else -> ADDITION
            }
        }
        val maximumRowSize = numberInputRows.maxOf { it.size }
        val problems = (0 until maximumRowSize).map { rowIndex ->
            CephalodMathsProblem(numberInputRows.mapNotNull { it[rowIndex].trim().toIntOrNull() }, operators[rowIndex])
        }

        return CephalodMaths(problems)
    }
}