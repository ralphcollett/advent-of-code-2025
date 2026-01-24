package day11

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class DeviceTest {

    @Test
    fun `Knows no paths from you to end when no devices`() {
        val devices = emptyList<Device>()

        val paths = pathsFromYouToEnd(devices)

        assertEquals(emptyList<List<String>>(), paths)
    }

    @Test
    fun `Knows no paths when no you device`() {
        val devices = listOf(
            Device("aaa", listOf("you", "hhhh")),
            Device("bbb", listOf("ddd", "eee")),
        )

        val paths = pathsFromYouToEnd(devices)

        assertEquals(emptyList<List<String>>(), paths)
    }

    @Test
    fun `Knows no paths when no links from you to end`() {
        val devices = listOf(
            Device("aaa", listOf("you", "hhhh")),
            Device("you", listOf("ddd", "eee")),
        )

        val paths = pathsFromYouToEnd(devices)

        assertEquals(emptyList<List<String>>(), paths)
    }

    private fun pathsFromYouToEnd(devices: List<Device>): List<List<String>> {
        return emptyList()
    }
}