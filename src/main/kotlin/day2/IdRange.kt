package day2

data class IdRange(val firstId: Int, val secondIdRange: Int)

fun findInvalidIds(range: IdRange): List<Int> {
    return (range.firstId ..range.secondIdRange).filter { idInvalid(it) }
}