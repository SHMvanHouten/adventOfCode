package com.github.shmvanhouten.adventofcode.day15timingiseverything

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class CapsuleDropTimeFinderTest {

    @Test
    fun `it should time that pressing the button at t=3 gives the capsule`() {
        val finder = CapsuleDropTimeFinder()
        var discMachine = DiscMachine()
        discMachine = discMachine.addDisc(Disc(amountOfPossiblePositions = 5, currentPosition = 3))
        assertThat(finder.findTimeToPressButton(discMachine), equalTo(1))
    }
}