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
            
            1
            5
            8
            11
            17
            32
        """.trimIndent()

        assertEquals(CafeteriaDatabase(
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
        ), parse(puzzleInput))
    }

    @Test
    fun `Ignores invalid ranges`() {
        val puzzleInput = """
            3-5
            a-2
            3-abc
            21
            
            2
        """.trimIndent()

        assertEquals(CafeteriaDatabase(
            listOf(FreshIngredientRange(3, 5)),
                listOf(2)
            ), parse(puzzleInput))
    }

    private fun parse(puzzleInput: String): CafeteriaDatabase {
        val (rangeInput, freshIngredientIdsInput) = puzzleInput.split("\n\n")
        val freshIngredientIdRanges = rangeInput.split("\n").mapNotNull { freshIngredientRow ->
            val freshIngredientIds = freshIngredientRow.split("-")
            val startIdInput = freshIngredientIds.first()
            val endIdInput = freshIngredientIds.getOrNull(1)
            val startId = startIdInput.toIntOrNull() ?: return@mapNotNull null
            val endId = endIdInput?.toIntOrNull() ?: return@mapNotNull null
            FreshIngredientRange(startId, endId)
        }
        val freshIngredientIds = freshIngredientIdsInput.split("\n").map { it.toInt() }
        return CafeteriaDatabase(
            freshIngredientIdRanges,
            freshIngredientIds
        )
    }
}