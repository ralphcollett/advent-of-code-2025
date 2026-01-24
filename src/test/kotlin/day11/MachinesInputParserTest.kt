package day11

import kotlin.test.Test
import kotlin.test.assertEquals

data class Device(val name: String, val connectedDeviceNames: List<String>)

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

    private fun parse(puzzleInput: String): List<Device> {
        return puzzleInput.split("\n").mapNotNull { deviceInput ->
            val name = deviceInput.substringBefore(":", "")?.takeIf { it.isNotEmpty() } ?: return@mapNotNull null
            val connectedDeviceNames = deviceInput.substringAfter(": ").split(" ")
            Device(
                name,
                connectedDeviceNames
            )
        }
    }
}