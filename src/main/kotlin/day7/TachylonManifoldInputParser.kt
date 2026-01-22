package day7

import day7.TachylonManifoldCell.*

fun parse(puzzleInput: String): TachylonManifold? {
    val cells = puzzleInput.split("\n").map { rowInput ->
        rowInput.map {
            when (it) {
                'S' -> TACHYLON_BEAM_START_POSITION
                '^' -> SPLITTER
                '.' -> EMPTY
                else -> return null
            }
        }
    }
    if (cells.any { it.size != cells.first().size }) return null
    if (! cells.first().contains(TACHYLON_BEAM_START_POSITION)) return null
    return TachylonManifold(cells)
}