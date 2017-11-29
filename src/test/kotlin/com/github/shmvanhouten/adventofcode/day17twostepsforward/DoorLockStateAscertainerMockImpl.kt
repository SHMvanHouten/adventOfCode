package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.OPEN

class DoorLockStateAscertainerMockImpl : DoorLockStateAscertainer {
    override fun findLockStateForDoorsAdjacent(doorCode: String): DoorsToAdjacentRooms {
        return when (doorCode) {
            "1234" -> DoorsToAdjacentRooms(down = OPEN)
            "1234D" -> DoorsToAdjacentRooms(right = OPEN)
            else -> DoorsToAdjacentRooms()
        }
    }
}