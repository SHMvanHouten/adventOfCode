package com.github.shmvanhouten.adventofcode.day17twostepsforward

import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.CLOSED
import com.github.shmvanhouten.adventofcode.day17twostepsforward.DoorState.OPEN
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class DoorLockStateDecoderMd5ImplTest {

    @Test
    fun `it should find up down left open and right closed `() {
        val decoderMd5Impl = DoorLockStateDecoderMd5Impl()
        assertThat(decoderMd5Impl.findLockStateForDoorsAdjacent("hijkl"), equalTo(DoorsToAdjacentRooms(OPEN, OPEN, OPEN, CLOSED)))
    }
}