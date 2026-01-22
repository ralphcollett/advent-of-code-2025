package day6


enum class CephalodMathOperator {
    ADDITION, MULTIPLICATION
}

data class CephalodMathProblem(val numbers: List<Int>, val operator: CephalodMathOperator)

data class CephalodMath(val problems: List<CephalodMathProblem>)

fun solveMathHomework(puzzleInput: String): Int {
    TODO("Not yet implemented")
}