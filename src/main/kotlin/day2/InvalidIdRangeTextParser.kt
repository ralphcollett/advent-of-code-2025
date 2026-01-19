package day2

fun parse(inputString: String): List<IdRange> {
    val rangesInputs = inputString.split(',')
    return rangesInputs.map { rangeInput ->
        val rangeIds = rangeInput.split("-").map { it.trim() }
        IdRange(rangeIds[0].toInt(), rangeIds[1].toInt())
    }
}