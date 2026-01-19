package day1

fun password(vararg rotations: Rotation): Int {
    return 0
}

class SecretEntrance {

    private var position = 50

    fun position(): Int = position

    fun left(distance: Int) {
        if (distance != 0) {
            if (position == 0) {
                position = 99
            } else {
                position--
            }
            left(distance - 1)
        }
    }

    fun right(distance: Int) {
        position += distance
    }
}
