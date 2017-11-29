package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.CLOSED
import com.github.shmvanhouten.adventofcode.day17twostepsforward.RelativePosition.*

data class DoorsToAdjacentRooms(val up: DoorState = CLOSED, val down: DoorState = CLOSED, val left: DoorState = CLOSED, val right: DoorState = CLOSED){
    fun getDoorStateForRelativePosition(relativePosition: RelativePosition): DoorState{
        return when(relativePosition){
            UP -> up
            DOWN -> down
            LEFT -> left
            RIGHT -> right
        }
    }
}

enum class DoorState{
    OPEN,
    CLOSED
}