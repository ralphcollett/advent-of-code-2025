package day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BankTest {

    @Test
    fun `Get joltage of bank`() {
        assertEquals(
            98, joltage(
                Bank(
                    listOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)
                )
            )
        )
    }

    @Test
    fun `No joltage if less than 2 batteries`() {
        assertEquals(0, joltage(Bank(emptyList())))
        assertEquals(0, joltage(Bank(listOf(2))))
    }

    private fun joltage(bank: Bank): Int {
        val batteries = bank.batteries
        if (batteries.size < 2) return 0
        val firstDigit = batteries.subList(0, batteries.size - 1).max()
        val secondDigit = batteries.subList(batteries.indexOf(firstDigit) + 1, batteries.size).max()
        return firstDigit * 10 + secondDigit
    }
}