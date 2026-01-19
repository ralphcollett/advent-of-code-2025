package day1

fun password(vararg rotations: Rotation): Int {
    return 0
}

class SecretEntrance {

    private var position = 50

    fun position(): Int = position

    fun left(distance: Int) {
        position -= distance
    }

    fun right(distance: Int) {
        position += distance
    }
}
