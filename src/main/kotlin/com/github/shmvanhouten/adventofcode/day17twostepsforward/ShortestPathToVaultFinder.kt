package com.github.shmvanhouten.adventofcode.day17twostepsforward

class ShortestPathToVaultFinder(private val roomMap: RoomMap, private val doorLockStateDecoder: DoorLockStateDecoder): PathToVaultFinder(roomMap, doorLockStateDecoder) {

    override fun find(passCode: String): String {
        val vaultRoom = roomMap.rooms.keys.maxBy { it }

        var unTakenPaths = initializeUntakenPaths(passCode)


        while (unTakenPaths.isNotEmpty()) {
            val unTakenPath = getShortestPossiblePath(unTakenPaths)
            unTakenPaths -= unTakenPath

            val relativePositionsWithOpenDoor = getRelativePositionsWithOpenDoor(unTakenPath)

            val possiblePathToVaultRoom = relativePositionsWithOpenDoor.filter { it.value == vaultRoom }
            if (possiblePathToVaultRoom.isNotEmpty()) {
                return possiblePathToVaultRoom.map { buildPath(unTakenPath, it) }[0].passCode.substringAfter(passCode)
            } else {
                unTakenPaths += relativePositionsWithOpenDoor.map { buildPath(unTakenPath, it) }
            }

        }
        println("No Path Found")
        return "-1"
    }
}