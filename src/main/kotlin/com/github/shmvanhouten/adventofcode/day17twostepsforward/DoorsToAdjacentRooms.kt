package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.RelativePosition.*

data class DoorsToAdjacentRooms(val up: DoorState, val down: DoorState, val left: DoorState, val right: DoorState) {

    fun getDoorStateForRelativePosition(relativePosition: RelativePosition): DoorState {
        return when (relativePosition) {
            UP -> up
            DOWN -> down
            LEFT -> left
            RIGHT -> right
        }
    }
}

enum class DoorState {
    OPEN,
    CLOSED
}