package day5

import day5.IngredientFreshness.FRESH
import day5.IngredientFreshness.SPOILED
import kotlin.test.Test
import kotlin.test.assertEquals

class CafeteriaTest {

    @Test
    fun `Knows if fresh ingredient based on range`() {
        assertEquals(FRESH, freshness(4, FreshIngredientRange(3, 5)))
    }

    @Test
    fun `Knows if fresh ingredient based on range including lower boundary`() {
        assertEquals(FRESH, freshness(3, FreshIngredientRange(3, 5)))
    }

    @Test
    fun `Knows if fresh ingredient based on range including upper boundary`() {
        assertEquals(FRESH, freshness(3, FreshIngredientRange(3, 5)))
    }

    @Test
    fun `Knows if spoiled ingredient`() {
        assertEquals(SPOILED, freshness(2, FreshIngredientRange(3, 5)))
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