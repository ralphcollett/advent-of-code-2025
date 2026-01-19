package day2

fun parse(inputString: String): List<IdRange> {
    val rangesInputs = inputString.split(',')
    return rangesInputs.mapNotNull { rangeInput ->
        val rangeIds = rangeInput.split("-").map { it.trim() }
        val firstId = rangeIds.getOrNull(0)?.toIntOrNull() ?: return@mapNotNull null
        val lastId = rangeIds.getOrNull(1)?.toIntOrNull() ?: return@mapNotNull null

        IdRange(firstId, lastId)
    }
}