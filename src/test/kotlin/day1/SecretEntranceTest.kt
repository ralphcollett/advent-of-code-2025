package day1

import day1.Direction.LEFT
import day1.Direction.RIGHT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import kotlin.test.Test

class SecretEntranceTest {

    /*
     * L68
     * L30
     * R48
     * L5
     * R60
     * L55
     * L1
     * L99
     * R14
     * L82
     * Password = 3
     */
    @Disabled
    @Test
    fun `Get's the password`() {
        assertEquals(3, password(
            Rotation(LEFT, 68),
            Rotation(LEFT, 30),
            Rotation(RIGHT, 48),
            Rotation(LEFT, 5),
            Rotation(RIGHT, 60),
            Rotation(LEFT, 55),
            Rotation(LEFT, 1),
            Rotation(LEFT, 99),
            Rotation(RIGHT, 14),
            Rotation(LEFT, 82),
        )
        )
    }

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