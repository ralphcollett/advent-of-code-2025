package day3

fun joltage(puzzleInput: String): Int {
    return parse(puzzleInput).sumOf {
        joltage(it)
    }
}