package day6

import day6.CephalodMathOperator.ADDITION
import day6.CephalodMathOperator.MULTIPLICATION

fun parse(puzzleInput: String): CephalodMath {
    val puzzleInputRows = puzzleInput.split("\n")
    val numberInputRows = puzzleInputRows.dropLast(1).map { it.trim().split("\\s+".toRegex()) }
    val operators = puzzleInputRows.last().split("\\s+".toRegex()).map {
        when (it) {
            "*" -> MULTIPLICATION
            "+" -> ADDITION
            else -> null
        }
    }
    val maximumRowSize = numberInputRows.minOf { it.size }
    val problems = (0 until maximumRowSize).mapNotNull { rowIndex ->
        val operator = operators[rowIndex] ?: return@mapNotNull null
        CephalodMathProblem(numberInputRows.map {
            it[rowIndex].toIntOrNull() ?: return@mapNotNull null
        }, operator)
    }

    return CephalodMath(problems)
}