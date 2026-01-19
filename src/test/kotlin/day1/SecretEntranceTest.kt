package day1

import day1.Direction.LEFT
import day1.Direction.RIGHT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import kotlin.test.Test

class SecretEntranceTest {

    private val secretEntrance = SecretEntrance()

    @Test
    fun `Start in position 50`() {
        assertEquals(50, secretEntrance.position())
    }

    @Test
    fun `Can move left`() {
        secretEntrance.left(10);

        assertEquals(40, secretEntrance.position())
    }
    
    @Test
    fun `Can move right`() {
        secretEntrance.right(20)

        assertEquals(70, secretEntrance.position())
    }
}