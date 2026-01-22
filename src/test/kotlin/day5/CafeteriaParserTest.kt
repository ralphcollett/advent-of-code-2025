package day5

import kotlin.test.Test
import kotlin.test.assertEquals

typealias FreshIngredientId = Int

data class FreshIngredientRange(val startId: FreshIngredientId, val endId: FreshIngredientId)

data class CafeteriaDatabase(val freshIngredientIdRanges: List<FreshIngredientRange>, val freshIngredientIds: List<FreshIngredientId>)

class CafeteriaParserTest {

    @Test
    fun `Parses puzzle input to database`() {
        val puzzleInput = """
            3-5
        """.trimIndent()

        assertEquals(CafeteriaDatabase(
            listOf(FreshIngredientRange(3, 5)),
            emptyList()
        ), parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): CafeteriaDatabase {
        val (startId, endId) = puzzleInput.split("-")
        return CafeteriaDatabase(
            listOf(FreshIngredientRange(startId.toInt(), endId.toInt())),
            emptyList()
        )
    }
}