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

    private fun parse(puzzleInput: String): List<Device> {
        return puzzleInput.split("\n").map { deviceInput ->
            val name = deviceInput.substringBefore(":")
            val connectedDeviceNames = deviceInput.substringAfter(": ").split(" ")
            Device(
                name,
                connectedDeviceNames
            )
        }
    }
}