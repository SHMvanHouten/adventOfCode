package com.github.shmvanhouten.adventofcode.day22gridcomputing

enum class RelativePosition(val coordinate: Coordinate) {
    UP(Coordinate(0, -1)),
    RIGHT(Coordinate(1, 0)),
    LEFT(Coordinate(-1, 0)),
    DOWN(Coordinate(0, 1)),
}