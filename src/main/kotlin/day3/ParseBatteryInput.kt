package day3

fun parse(puzzleInput: String): List<Bank> {
    return puzzleInput.split("\n").map {
        bankInput ->
            Bank(bankInput.mapNotNull { it.digitToIntOrNull() }.filterNot { it == 0 })
    }
}