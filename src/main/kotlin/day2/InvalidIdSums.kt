package day2

fun invalidIdSums(puzzleInputStream: String): Int {
    return parse(puzzleInputStream)
        .flatMap { findInvalidIds(it) }
        .sum()
}