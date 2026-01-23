package day9

import kotlin.math.absoluteValue

fun area(corner1: Tile, corner2: Tile): Int {
    val (x1, y1) = corner1
    val (x2, y2) = corner2

    val width = (x1 - x2).absoluteValue + 1
    val height = (y1 - y2).absoluteValue + 1
    return width * height
}