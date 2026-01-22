package day6


enum class CephalodMathsOperator {
    ADDITION, MULTIPLICATION
}

data class CephalodMathsProblem(val numbers: List<Int>, val operator: CephalodMathsOperator)

data class CephalodMaths(val problems: List<CephalodMathsProblem>)

fun solveMathHomework(puzzleInput: String): Int {
    TODO("Not yet implemented")
}