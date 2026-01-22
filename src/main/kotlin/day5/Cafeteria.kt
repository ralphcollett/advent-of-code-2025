package day5

import day5.IngredientFreshness.FRESH
import day5.IngredientFreshness.SPOILED

typealias FreshIngredientId = Int

data class FreshIngredientRange(val startId: FreshIngredientId, val endId: FreshIngredientId)

data class CafeteriaDatabase(val freshIngredientIdRanges: List<FreshIngredientRange>, val freshIngredientIds: List<FreshIngredientId>)

enum class IngredientFreshness {
    FRESH,
    SPOILED
}

fun countFreshIngredients(puzzleInputTest: String): Int {
    return 0
}

fun countFreshIngredients(database: CafeteriaDatabase): Int {
    val (ingredientRanges, ingredientIds) = database
    return ingredientIds.count { ingredientId ->
        ingredientRanges.any { ingredientRange ->
            freshness(ingredientId, ingredientRange) == FRESH
        }
    }
}

fun freshness(ingredientId: FreshIngredientId, freshIngredientRange: FreshIngredientRange): IngredientFreshness {
    val idInRange = freshIngredientRange.run {
        startId..endId
    }.contains(ingredientId)
    return when {
        idInRange -> FRESH
        else -> SPOILED
    }
}