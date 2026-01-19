package day1

import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun `Move left from zero moves to 99`() {
        secretEntrance.left(51)

        assertEquals(99, secretEntrance.position())
    }

    @Test
    fun `Move right above 99 starts at zero`() {
        secretEntrance.right(60)

        assertEquals(10, secretEntrance.position())
    }
}