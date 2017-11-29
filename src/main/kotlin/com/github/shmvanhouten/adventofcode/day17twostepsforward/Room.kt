package com.github.shmvanhouten.adventofcode.day17twostepsforward

data class Room(val adjacentRooms: Map<RelativePosition, Coordinate>)

enum class RelativePosition {
    UP,
    DOWN,
    LEFT,
    RIGHT
}