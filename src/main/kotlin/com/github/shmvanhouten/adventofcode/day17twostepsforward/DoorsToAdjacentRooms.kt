package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.CLOSED

data class DoorsToAdjacentRooms(val up: DoorState = CLOSED, val down: DoorState = CLOSED, val left: DoorState = CLOSED, val right: DoorState = CLOSED)

enum class DoorState{
    OPEN,
    CLOSED
}