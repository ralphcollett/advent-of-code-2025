package day3

typealias Battery = Int

data class Bank(val batteries: List<Battery>)

fun joltage(bank: Bank): Int {
    val batteries = bank.batteries
    if (batteries.size < 2) return 0
    val firstDigit = batteries.subList(0, batteries.size - 1).max()
    val secondDigit = batteries.subList(batteries.indexOf(firstDigit) + 1, batteries.size).max()
    return firstDigit * 10 + secondDigit
}