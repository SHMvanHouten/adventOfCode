package com.github.shmvanhouten.adventofcode.day17twostepsforward

data class Room(val adjacentRooms: Map<RelativePosition, Coordinate>)

enum class RelativePosition(val charRepresentation: Char) {
    UP('U'),
    DOWN('D'),
    LEFT('L'),
    RIGHT('R')
}