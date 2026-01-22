package day5

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