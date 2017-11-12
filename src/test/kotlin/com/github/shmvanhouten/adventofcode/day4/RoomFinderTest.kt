package com.github.shmvanhouten.adventofcode.day4

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test


class RoomFinderTest {

    @Test
    fun `it should find the sector id for the room very encrypted name`() {
        val roomFinder = RoomFinder()
        assertThat(roomFinder.findRoomWithName("very encrypted name", "qzmt-zixmtkozy-ivhz-343[zimth]"), `is`(343))
    }

    @Test
    fun `it Should find the sector id for the room northpole object storage`() {
        val roomFinder = RoomFinder()
        assertThat(roomFinder.findRoomWithName("northpole object storage", challengeInputKeys), `is`(482))
    }
}