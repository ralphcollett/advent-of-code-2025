package day6

import day6.CephalodMathOperator.ADDITION
import day6.CephalodMathOperator.MULTIPLICATION
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CephalodMathTest {

    @Test
    fun `Performs addition`() {
        val calculation = calculate(CephalodMath(
            listOf(
                CephalodMathProblem(
                    listOf(328, 64, 98),
                    ADDITION
                )
            )
        ))

        assertEquals(490, calculation)
    }

    @Test
    fun `Performs multiplication`() {
        val calculation = calculate(CephalodMath(
            listOf(
                CephalodMathProblem(
                    listOf(123, 45, 6),
                    MULTIPLICATION
                )
            )
        ))

        assertEquals(33210, calculation)
    }

    private fun calculate(cephalodMath: CephalodMath): Int {
        val cephalodMathProblem = cephalodMath.problems.first()
        return cephalodMathProblem.numbers.reduce { acc, i ->
            cephalodMathProblem.operator.operate(acc, i)
        }
    }
}