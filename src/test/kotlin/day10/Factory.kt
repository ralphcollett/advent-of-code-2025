package day10

fun minimumButtonPresses(puzzleInput: String): Int?  {
    return parse(puzzleInput).map { manual ->
        val machine = Machine(manual.indicatorLightDiagram.size)
        val fewestPresses = machine.findFewestPressesToMeetIndicatorDiagram(manual)
        fewestPresses ?: return null
    }.sum()
}