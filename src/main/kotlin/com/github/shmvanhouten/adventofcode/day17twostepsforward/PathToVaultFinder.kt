package com.github.shmvanhouten.adventofcode.day17twostepsforward

abstract class PathToVaultFinder(private val roomMap: RoomMap, private val doorLockStateDecoder: DoorLockStateDecoder) {
    abstract fun find(passCode: String): String

    fun buildPath(possiblePath: Path, positionToCoordinateEntry: Map.Entry<RelativePosition, Coordinate>): Path {
        val passCode = possiblePath.passCode + positionToCoordinateEntry.key.charRepresentation
        val currentRoom = roomMap.rooms.getValue(positionToCoordinateEntry.value)
        val lockStateForDoorsAdjacent = doorLockStateDecoder.findLockStateForDoorsAdjacent(passCode)
        return Path(passCode, currentRoom, lockStateForDoorsAdjacent)
    }

    fun getShortestPossiblePath(possiblePaths: Set<Path>): Path {
        return possiblePaths.minBy { it.passCode.length } ?: possiblePaths.first()
    }

    fun getRelativePositionsWithOpenDoor(unTakenPath: Path) =
            unTakenPath.currentRoom.adjacentRooms
                    .filter { unTakenPath.doorsToAdjacentRooms.getDoorStateForRelativePosition(it.key) == DoorState.OPEN }


    fun initializeUntakenPaths(passCode: String): Set<Path> {
        val doorsAdjacent = doorLockStateDecoder.findLockStateForDoorsAdjacent(passCode)
        return setOf(Path(passCode, roomMap.rooms.getValue(Coordinate(0, 0)), doorsAdjacent))
    }
}