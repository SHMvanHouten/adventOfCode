package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class ShortestPathToVaultFinderTest {


    @Test
    fun `it should find the quickest path to the vault to be DR`() {
        val roomMap = buildSmallRoomMap()
        val doorLockStateAscertainer = DoorLockStateAscertainerMockImpl()
        val shortestPathFinder = ShortestPathToVaultFinder(roomMap, doorLockStateAscertainer)
        assertThat(shortestPathFinder.findShortestPath("1234"), equalTo("DR"))
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


    private fun buildStandardRoomMap(): RoomMap {
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
}