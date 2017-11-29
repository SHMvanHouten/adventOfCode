package com.github.shmvanhouten.adventofcode.day17twostepsforward

interface DoorLockStateDecoder {

    fun findLockStateForDoorsAdjacent(doorCode: String): DoorsToAdjacentRooms
}