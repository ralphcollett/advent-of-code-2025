package day11

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class DeviceTest {

    @Test
    fun `Knows no paths from you to out when no devices`() {
        val devices = emptyList<Device>()

        val paths = pathsFromYouToOut(devices)

        assertEquals(emptyList<List<String>>(), paths)
    }

    @Test
    fun `Knows no paths when no you device`() {
        val devices = listOf(
            Device("aaa", listOf("you", "hhhh")),
            Device("bbb", listOf("ddd", "eee")),
        )

        val paths = pathsFromYouToOut(devices)

        assertEquals(emptyList<List<String>>(), paths)
    }

    @Test
    fun `Knows no paths when no links from you to out`() {
        val devices = listOf(
            Device("aaa", listOf("you", "hhhh")),
            Device("you", listOf("ddd", "eee")),
        )

        val paths = pathsFromYouToOut(devices)

        assertEquals(emptyList<List<String>>(), paths)
    }

    @Test
    fun `Knows when path with length 1 from you to out`() {
        val devices = listOf(
            Device("aaa", listOf("you", "hhhh")),
            Device("you", listOf("out", "ggg")),
        )

        val paths = pathsFromYouToOut(devices)

        val expectedPaths = listOf(listOf("you", "out"))
        assertEquals(expectedPaths, paths)
    }

    @Test
    fun `Knows path from you to out with length of 2`() {
        val devices = listOf(
            Device("aaa", listOf("out", "hhhh")),
            Device("you", listOf("aaa", "ggg")),
        )

        val paths = pathsFromYouToOut(devices)

        val expectedPaths = listOf(listOf("you", "aaa", "out"))
        assertEquals(expectedPaths, paths)
    }

    @Test
    fun `Finds multiple paths`() {
        val devices = listOf(
            Device("aaa", listOf("you", "hhhh")),
            Device("you", listOf("bbb", "ccc")),
            Device("bbb", listOf("ddd", "eee")),
            Device("ccc", listOf("ddd", "eee", "fff")),
            Device("ddd", listOf("ggg")),
            Device("eee", listOf("out")),
            Device("fff", listOf("out")),
            Device("ggg", listOf("out")),
            Device("hhh", listOf("ccc", "fff", "iii")),
            Device("iii", listOf("out")),
        )

        val paths = pathsFromYouToOut(devices)

        val expectedPaths = listOf(
            listOf("you", "bbb", "ddd", "ggg", "out"),
            listOf("you", "bbb", "eee", "out"),
            listOf("you", "ccc", "ddd", "ggg", "out"),
            listOf("you", "ccc", "eee", "out"),
            listOf("you", "ccc", "fff", "out"),
        )

        assertEquals(expectedPaths, paths)
    }
}