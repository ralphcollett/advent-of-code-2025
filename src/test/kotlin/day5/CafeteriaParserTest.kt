package day5

import kotlin.test.Test
import kotlin.test.assertEquals

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
    
    @Test
    fun `Ignore invalid IDs`() {
        val puzzleInput = """
            3-5
            
            a
            2
            ??
            34
        """.trimIndent()

        assertEquals(CafeteriaDatabase(
            listOf(FreshIngredientRange(3, 5)),
            listOf(2, 34)
        ), parse(puzzleInput))
    }

}