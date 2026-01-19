package day3

import org.junit.jupiter.api.Disabled
import kotlin.test.Test
import kotlin.test.assertEquals

class BatteryJoltageAcceptanceTest {

    @Test
    @Disabled
    fun `Gets joltage from input`() {
        assertEquals(357, joltage(
            """
                987654321111111
                811111111111119
                234234234234278
                818181911112111
            """.trimIndent()
        ))
    }

}