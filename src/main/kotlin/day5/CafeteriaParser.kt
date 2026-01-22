package day5

fun parse(puzzleInput: String): CafeteriaDatabase {
    val (rangeInput, freshIngredientIdsInput) = puzzleInput.split("\n\n")
    val freshIngredientIdRanges = rangeInput.split("\n").mapNotNull { freshIngredientRow ->
        val freshIngredientIds = freshIngredientRow.split("-")
        val startIdInput = freshIngredientIds.first()
        val endIdInput = freshIngredientIds.getOrNull(1)
        val startId = startIdInput.toIntOrNull() ?: return@mapNotNull null
        val endId = endIdInput?.toIntOrNull() ?: return@mapNotNull null
        FreshIngredientRange(startId, endId)
    }
    val freshIngredientIds = freshIngredientIdsInput.split("\n").mapNotNull { it.toIntOrNull() }
    return CafeteriaDatabase(
        freshIngredientIdRanges,
        freshIngredientIds
    )
}