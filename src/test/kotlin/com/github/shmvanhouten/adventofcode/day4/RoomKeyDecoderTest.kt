package com.github.shmvanhouten.adventofcode.day4

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test


class RoomKeyDecoderTest {

    @Test
    fun `it should assert aaaaa-bbb-z-y-x-123(abxyz) is a valid room key`() {
        val key = "aaaaa-bbb-z-y-x-123[abxyz]"
        val keyDecoder = RoomKeyDecoder()
        assertThat(keyDecoder.checkIfRoomIsReal(key), `is`(true))
    }

    @Test
    fun `it should assert bbbbb-aaa-z-y-x-123(abxyz) is not a valid room key`() {
        val key = "bbbbb-aaa-z-y-x-123[abxyz]"
        val keyDecoder = RoomKeyDecoder()
        assertThat(keyDecoder.checkIfRoomIsReal(key), `is`(false))
    }

}