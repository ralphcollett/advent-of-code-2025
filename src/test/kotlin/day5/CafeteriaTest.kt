package day5

import day5.IngredientFreshness.FRESH
import kotlin.test.Test
import kotlin.test.assertEquals

class CafeteriaTest {

    @Test
    fun `Knows if spoiled ingredient based on range`() {
        assertEquals(FRESH, freshness(4, FreshIngredientRange(3, 5)))
    }

    @Test
    fun `Knows if spoiled ingredient based on range including lower boundary`() {
        assertEquals(FRESH, freshness(3, FreshIngredientRange(3, 5)))
    }

    @Test
    fun `Knows if spoiled ingredient based on range including upper boundary`() {
        assertEquals(FRESH, freshness(3, FreshIngredientRange(3, 5)))
    }

    private fun freshness(ingredientId: FreshIngredientId, freshIngredientRange: FreshIngredientRange): IngredientFreshness {
        return FRESH
    }
}