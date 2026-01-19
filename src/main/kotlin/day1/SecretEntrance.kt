package day1

import day1.Direction.LEFT
import day1.Direction.RIGHT

fun password(rotations: String): Int {
    return password(* parse(rotations).toTypedArray())
}

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

    private val dialPositions = 100

    private var position = 50

    private var password = 0

    fun position(): Int = position

    fun left(distance: Int) {
        right(dialPositions - distance)
    }

    fun right(distance: Int) {
        position = (position + distance).mod(dialPositions )
        if (position == 0) {
            password++
        }
    }

    fun password(): Int = password
}
