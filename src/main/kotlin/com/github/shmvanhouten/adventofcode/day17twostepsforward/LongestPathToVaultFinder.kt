package com.github.shmvanhouten.adventofcode.day17twostepsforward

class LongestPathToVaultFinder(private val roomMap: RoomMap, private val doorLockStateDecoder: DoorLockStateDecoder): PathToVaultFinder(roomMap, doorLockStateDecoder) {

    override fun find(passCode: String): String {
        val vaultRoom = roomMap.rooms.keys.maxBy { it }

        var unTakenPaths = initializeUntakenPaths(passCode)

        var stepsLeadingToVault = listOf<String>()


        while (unTakenPaths.isNotEmpty()) {
            val unTakenPath = getShortestPossiblePath(unTakenPaths)
            unTakenPaths -= unTakenPath

            val relativePositionsWithOpenDoor = getRelativePositionsWithOpenDoor(unTakenPath)

            val possiblePathToVaultRoom = relativePositionsWithOpenDoor.filter { it.value == vaultRoom }
            if (possiblePathToVaultRoom.isNotEmpty()) {
                stepsLeadingToVault += possiblePathToVaultRoom.map { buildPath(unTakenPath, it) }[0].passCode.substringAfter(passCode)
            }
            unTakenPaths += relativePositionsWithOpenDoor.map { buildPath(unTakenPath, it) }


        }
        return stepsLeadingToVault.maxBy { it.length } ?: "-1"
    }

}