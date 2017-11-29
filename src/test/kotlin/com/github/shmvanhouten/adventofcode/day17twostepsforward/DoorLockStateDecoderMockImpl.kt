package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.CLOSED
import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.OPEN

class DoorLockStateDecoderMockImpl : DoorLockStateDecoder {
    override fun findLockStateForDoorsAdjacent(doorCode: String): DoorsToAdjacentRooms {
        return when (doorCode) {
            "1234" -> DoorsToAdjacentRooms(up = CLOSED, down = OPEN, right = CLOSED, left = CLOSED)
            "1234D" -> DoorsToAdjacentRooms(up = CLOSED, down = CLOSED, right = OPEN, left = CLOSED)
            else -> DoorsToAdjacentRooms(CLOSED, CLOSED, CLOSED, CLOSED)
        }
    }
}