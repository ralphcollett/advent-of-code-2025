package day9

import kotlin.test.Test
import kotlin.test.assertEquals

class RectangleTest {

    @Test
    fun `Works out rectangle area from 2 tiles as corners`() {
        assertEquals(24, area(Tile(2, 5), Tile(9, 7)))
        assertEquals(35, area(Tile(7, 1), Tile(11, 7)))
        assertEquals(6, area(Tile(7, 3), Tile(2, 3)))
    }

}