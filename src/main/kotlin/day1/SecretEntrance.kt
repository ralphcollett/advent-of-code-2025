package day1

fun password(vararg rotations: Rotation): Int {
    return 0
}

class SecretEntrance {

    private val maximumPosition = 99

    private var position = 50

    fun position(): Int = position

    fun left(distance: Int) {
        if (distance != 0) {
            if (position == 0) {
                position = maximumPosition
            } else {
                position--
            }
            left(distance - 1)
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
        }
    }

    fun password(): Int = 0
}
