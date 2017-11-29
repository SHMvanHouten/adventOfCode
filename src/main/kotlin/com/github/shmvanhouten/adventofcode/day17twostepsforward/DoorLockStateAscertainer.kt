package com.github.shmvanhouten.adventofcode.day17twostepsforward

interface DoorLockStateAscertainer {

    fun findLockStateForDoorsAdjacent(doorCode: String): DoorsToAdjacentRooms
}