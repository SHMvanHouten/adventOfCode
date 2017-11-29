package com.github.shmvanhouten.adventofcode.day17twostepsforward

class LongestPathToVaultFinder(private val roomMap: RoomMap, private val doorLockStateDecoder: DoorLockStateDecoder) {
    fun findLongestPath(passCode: String): Int {
        val vaultRoom = roomMap.rooms.keys.maxBy { it }

        val doorsAdjacent = doorLockStateDecoder.findLockStateForDoorsAdjacent(passCode)
        var unTakenPaths = setOf<Path>(Path(passCode, roomMap.rooms.getValue(Coordinate(0, 0)), doorsAdjacent))

        var pathsToVault = listOf<String>()


        while (unTakenPaths.isNotEmpty()) {
            val unTakenPath = getShortestPossiblePath(unTakenPaths)
            unTakenPaths -= unTakenPath

            var relativePositionsWithOpenDoor = unTakenPath.currentRoom.adjacentRooms
                    .filter { unTakenPath.doorsToAdjacentRooms.getDoorStateForRelativePosition(it.key) == DoorState.OPEN }

            val possiblePathToVaultRoom = relativePositionsWithOpenDoor.filter { it.value == vaultRoom }
            if (possiblePathToVaultRoom.isNotEmpty()) {
                pathsToVault += possiblePathToVaultRoom.map { buildPath(unTakenPath, it) }[0].passCode.substringAfter(passCode)
                relativePositionsWithOpenDoor -= (possiblePathToVaultRoom.keys)
            }
            unTakenPaths += relativePositionsWithOpenDoor.map { buildPath(unTakenPath, it) }


        }
        return pathsToVault.maxBy { it.length }?.length ?: -1
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