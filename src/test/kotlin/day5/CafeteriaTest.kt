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

    private fun freshness(ingredientId: FreshIngredientId, freshIngredientRange: FreshIngredientRange): IngredientFreshness {
        val idInRange = freshIngredientRange.run {
            startId..endId
        }.contains(ingredientId)
        return when {
            idInRange -> FRESH
            else -> SPOILED
        }
    }
}