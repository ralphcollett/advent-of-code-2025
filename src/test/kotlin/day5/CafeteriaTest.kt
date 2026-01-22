package day5

import kotlin.test.Test
import kotlin.test.assertEquals

class CafeteriaTest {

    @Test
    fun `Knows if fresh ingredient based on range`() {
        assertEquals(1, countFreshIngredients(
            CafeteriaDatabase(
                listOf(FreshIngredientRange(3, 5)),
                listOf(4)
            ))
        )
    }

    @Test
    fun `Knows if fresh ingredient based on range including lower boundary`() {
        assertEquals(1, countFreshIngredients(
            CafeteriaDatabase(
                listOf(FreshIngredientRange(3, 5)),
                listOf(3)
            ))
        )
    }

    @Test
    fun `Knows if fresh ingredient based on range including upper boundary`() {
        assertEquals(1, countFreshIngredients(
            CafeteriaDatabase(
                listOf(FreshIngredientRange(3, 5)),
                listOf(3)
            ))
        )
    }

    @Test
    fun `Knows if spoiled ingredient`() {
        assertEquals(0, countFreshIngredients(
            CafeteriaDatabase(
                listOf(FreshIngredientRange(3, 5)),
                listOf(2)
            ))
        )
    }

    @Test
    fun `Knows freshness of multiple ingredient IDs in range`() {
        val freshIngredientCount =  countFreshIngredients(
            CafeteriaDatabase(
                listOf(
                    FreshIngredientRange(3, 5),
                    FreshIngredientRange(10, 14),
                    FreshIngredientRange(16, 20),
                    FreshIngredientRange(12, 18)
                ),
                listOf(
                    1,
                    5,
                    8,
                    11,
                    17,
                    32
                )
            )
        )

        assertEquals(3, freshIngredientCount)
    }
}