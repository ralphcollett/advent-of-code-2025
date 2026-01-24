package day11

import kotlin.test.Test
import kotlin.test.assertEquals

class MachinesInputParserTest {

    @Test
    fun `Parses input`() {
        val devices = parse(
            """
            aaa: you hhh
            you: bbb ccc
            bbb: ddd eee
            ccc: ddd eee fff
        """.trimIndent()
        )

        assertEquals(
            listOf(
                Device("aaa", listOf("you", "hhh")),
                Device("you", listOf("bbb", "ccc")),
                Device("bbb", listOf("ddd", "eee")),
                Device("ccc", listOf("ddd", "eee", "fff")),
            ),
            devices
        )
    }

    @Test
    fun `Ignores machines with missing name`() {
        val devices = parse(
            """
            aaa: you hhh
            ddd eee
        """.trimIndent()
        )

        assertEquals(
            listOf(
                Device("aaa", listOf("you", "hhh")),
            ),
            devices
        )
    }

}