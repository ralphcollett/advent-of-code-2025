package day10

fun minimumButtonPresses(puzzleInput: String): Int?  {
    return parse(puzzleInput).mapNotNull { manual ->
        Machine(manual.indicatorLightDiagram.size).findFewestPressesToMeetIndicatorDiagram(manual)
    }.takeIf { it.isNotEmpty() }?.sum()
}