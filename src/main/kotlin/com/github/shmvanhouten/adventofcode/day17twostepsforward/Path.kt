package com.github.shmvanhouten.adventofcode.day17twostepsforward

data class Path(val passCode: String, val currentRoom: Room, val doorsToAdjacentRooms: DoorsToAdjacentRooms){
    override fun equals(other: Any?): Boolean {
        val otherPath = other as Path
        return this.passCode == otherPath.passCode
    }

    override fun hashCode(): Int {
        return passCode.hashCode()
    }

}