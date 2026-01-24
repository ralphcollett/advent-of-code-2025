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

    @Test
    fun `Knows when path with length 1 from you to end`() {
        val devices = listOf(
            Device("aaa", listOf("you", "hhhh")),
            Device("you", listOf("end", "ggg")),
        )

        val paths = pathsFromYouToEnd(devices)

        val expectedPaths = listOf(listOf("you", "end"))
        assertEquals(expectedPaths, paths)
    }

    @Test
    fun `Knows path from you to end with length of 2`() {
        val devices = listOf(
            Device("aaa", listOf("end", "hhhh")),
            Device("you", listOf("aaa", "ggg")),
        )

        val paths = pathsFromYouToEnd(devices)

        val expectedPaths = listOf(listOf("you", "aaa", "end"))
        assertEquals(expectedPaths, paths)
    }
}