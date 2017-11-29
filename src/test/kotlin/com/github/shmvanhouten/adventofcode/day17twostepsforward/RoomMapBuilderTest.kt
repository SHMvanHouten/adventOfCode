package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class RoomMapBuilderTest {

    @Test
    fun `it should build a map of the room from the raw input string`() {
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
        val roomMap = roomMapBuilder.buildRoomMap(rawInput)
        assertThat(roomMap.rooms.size, equalTo(9))
        roomMap.rooms.forEach { println(it) }
    }
}
