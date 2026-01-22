package day6

import day6.CephalodMathOperator.ADDITION
import day6.CephalodMathOperator.MULTIPLICATION
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CephalodMathTest {

    @Test
    fun `Performs addition`() {
        val calculation = calculate(
            CephalodMath(
                listOf(
                    CephalodMathProblem(
                        listOf(328, 64, 98),
                        ADDITION
                    )
                )
            )
        )

        assertEquals(490, calculation)
    }

    @Test
    fun `Performs multiplication`() {
        val calculation = calculate(
            CephalodMath(
                listOf(
                    CephalodMathProblem(
                        listOf(123, 45, 6),
                        MULTIPLICATION
                    )
                )
            )
        )

        assertEquals(33210, calculation)
    }

    @Test
    fun `Gets total of multiple calculations`() {
        val calculation = calculate(
            CephalodMath(
                listOf(
                    CephalodMathProblem(listOf(123, 45, 6), MULTIPLICATION),
                    CephalodMathProblem(listOf(328, 64, 98), ADDITION),
                    CephalodMathProblem(listOf(51, 387, 215), MULTIPLICATION),
                    CephalodMathProblem(listOf(64, 23, 314), ADDITION)
                )
            )
        )

        assertEquals(4277556, calculation)
    }
}