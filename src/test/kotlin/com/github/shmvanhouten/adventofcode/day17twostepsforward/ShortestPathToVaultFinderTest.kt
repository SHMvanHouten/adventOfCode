package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class ShortestPathToVaultFinderTest {


    @Test
    fun `it should find the quickest path to the vault to be DR`() {
        val roomMap = buildSmallRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMockImpl()
        val shortestPathFinder = ShortestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.findShortestPath("1234"), equalTo("DR"))
    }

    @Test
    fun `it should find the path DDRRRD for passcode ihgpwlah`() {
        val roomMap = buildStandardRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMd5Impl()
        val shortestPathFinder = ShortestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.findShortestPath("ihgpwlah"), equalTo("DDRRRD"))
    }

    @Test
    fun `it should find the path DDUDRLRRUDRD for passcode kglvqrro`() {
        val roomMap = buildStandardRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMd5Impl()
        val shortestPathFinder = ShortestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.findShortestPath("kglvqrro"), equalTo("DDUDRLRRUDRD"))
    }

    @Test
    fun `it should find the path DRURDRUDDLLDLUURRDULRLDUUDDDRR for passcode ulqzkmiv`() {
        val roomMap = buildStandardRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMd5Impl()
        val shortestPathFinder = ShortestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.findShortestPath("ulqzkmiv"), equalTo("DRURDRUDDLLDLUURRDULRLDUUDDDRR"))
    }

    @Test
    fun `it should find the path DDURRLRRDD for challenge input passcode bwnlcvfs`() {
        val roomMap = buildStandardRoomMap()
        val doorLockStateAscertainer = DoorLockStateDecoderMd5Impl()
        val shortestPathFinder = ShortestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.findShortestPath("bwnlcvfs"), equalTo("DDURRLRRDD"))
    }




    private fun buildSmallRoomMap(): RoomMap {
        val roomMapBuilder = RoomMapBuilder()
        val rawInput = """#####
    #S| #
    #-#-#
    # | #
    ###V"""
        return roomMapBuilder.buildRoomMap(rawInput)
    }


}

fun buildStandardRoomMap(): RoomMap {
    val roomMapBuilder = RoomMapBuilder()
    val rawInput = """#########
    #S| | | #
    #-#-#-#-#
    # | | | #
    #-#-#-#-#
    # | | | #
    #-#-#-#-#
    # | | |
    ####### V"""
    return roomMapBuilder.buildRoomMap(rawInput)
}