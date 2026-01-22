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
            10-14
            16-20
            12-18
        """.trimIndent()

        assertEquals(CafeteriaDatabase(
            listOf(
                FreshIngredientRange(3, 5),
                FreshIngredientRange(10, 14),
                FreshIngredientRange(16, 20),
                FreshIngredientRange(12, 18)
            ),
            emptyList()
        ), parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): CafeteriaDatabase {
        val freshIngredientIdRanges = puzzleInput.split("\n").map { puzzleRow ->
            val (startId, endId) = puzzleRow.split("-")
            FreshIngredientRange(startId.toInt(), endId.toInt())
        }
        return CafeteriaDatabase(
            freshIngredientIdRanges,
            emptyList()
        )
    }
}