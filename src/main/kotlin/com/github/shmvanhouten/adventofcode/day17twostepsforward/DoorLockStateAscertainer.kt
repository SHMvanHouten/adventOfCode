package com.github.shmvanhouten.adventofcode.day17twostepsforward

interface DoorLockStateAscertainer {

    fun findLockStateForDoorsAdjacentTo(doorCode: String): Room
}