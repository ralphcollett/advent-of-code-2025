package day1

import day1.Direction.LEFT
import day1.Direction.RIGHT

fun password(vararg rotations: Rotation): Int {
    val secretEntrance = SecretEntrance()
    rotations.forEach { rotation ->
        when (rotation.direction) {
            LEFT -> secretEntrance.left(rotation.distance)
            RIGHT -> secretEntrance.right(rotation.distance)
        }
    }
    return secretEntrance.password()
}

class SecretEntrance {

    private val maximumPosition = 99

    private var position = 50

    private var password = 0

    fun position(): Int = position

    fun left(distance: Int) {
        if (distance != 0) {
            if (position == 0) {
                position = maximumPosition
            } else {
                position--
            }
            left(distance - 1)
        } else if (position == 0) {
            password++
        }
    }

    fun right(distance: Int) {
        if (distance != 0) {
            if (position == maximumPosition) {
                position = 0
            } else {
                position++
            }
            right(distance - 1)
        } else if (position == 0) {
            password++
        }
    }

    fun password(): Int = password
}
