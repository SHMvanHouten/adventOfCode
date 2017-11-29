package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.OPEN

class ShortestPathToVaultFinder(private val roomMap: RoomMap, private val doorLockStateDecoder: DoorLockStateDecoder) {
    fun findShortestPath(passCode: String): String {
        val vaultRoom = roomMap.rooms.keys.maxBy { it }

        val doorsAdjacent = doorLockStateDecoder.findLockStateForDoorsAdjacent(passCode)
        var unTakenPaths = setOf<Path>(Path(passCode, roomMap.rooms.getValue(Coordinate(0, 0)), doorsAdjacent))


        while (unTakenPaths.isNotEmpty()) {
            val unTakenPath = getShortestPossiblePath(unTakenPaths)
            unTakenPaths -= unTakenPath

            val relativePositionsWithOpenDoor = unTakenPath.currentRoom.adjacentRooms
                    .filter { unTakenPath.doorsToAdjacentRooms.getDoorStateForRelativePosition(it.key) == OPEN }

            val possiblePathToVaultRoom = relativePositionsWithOpenDoor.filter { it.value == vaultRoom }
            if (possiblePathToVaultRoom.isNotEmpty()) {
                return possiblePathToVaultRoom.map { buildPath(unTakenPath, it) }[0].passCode.substringAfter(passCode)
            } else {
                unTakenPaths += relativePositionsWithOpenDoor.map { buildPath(unTakenPath, it) }
            }

        }
        return "-1"
    }

    private fun buildPath(possiblePath: Path, entry: Map.Entry<RelativePosition, Coordinate>): Path {
        val passCode = possiblePath.passCode + entry.key.charRepresentation
        val currentRoom = roomMap.rooms.getValue(entry.value)
        val lockStateForDoorsAdjacent = doorLockStateDecoder.findLockStateForDoorsAdjacent(passCode)
        return Path(passCode, currentRoom, lockStateForDoorsAdjacent)
    }

    private fun getShortestPossiblePath(possiblePaths: Set<Path>): Path {
        return possiblePaths.minBy { it.passCode.length } ?: possiblePaths.first()
    }
}