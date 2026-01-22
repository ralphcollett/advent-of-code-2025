package day7

fun countSplits(puzzleInput: String): Int {
    return generateSequence(parse(puzzleInput)) {
        val moveDown = it.moveDown()
        if (moveDown == it) return@generateSequence null
        moveDown
    }.toList().last().splits()
}