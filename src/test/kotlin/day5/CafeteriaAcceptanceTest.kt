package day5

import kotlin.test.Test
import kotlin.test.assertEquals

class CafeteriaAcceptanceTest {

    @Test
    fun `Counts fresh ingredients`() {
        val freshIngrediantCount = countFreshIngredients(
            """
                3-5
                10-14
                16-20
                12-18

                1
                5
                8
                11
                17
                32
            """.trimIndent()
        )

        assertEquals(3, freshIngrediantCount)
    }
}