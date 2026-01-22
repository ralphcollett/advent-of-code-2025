package day6


enum class CephalodMathOperator {
    ADDITION {
        override fun operate(a: Int, b: Int): Int = a + b
    },
    MULTIPLICATION {
        override fun operate(a: Int, b: Int): Int = a * b
    };

    abstract fun operate(a: Int, b: Int): Int
}

data class CephalodMathProblem(val numbers: List<Int>, val operator: CephalodMathOperator)

data class CephalodMath(val problems: List<CephalodMathProblem>)

fun solveMathHomework(puzzleInput: String): Int = calculate(parse(puzzleInput))

fun calculate(cephalodMath: CephalodMath): Int {
    return cephalodMath.problems.sumOf { (numbers, operator) ->
        numbers.reduce { acc, i ->
            operator.operate(acc, i)
        }
    }
}
