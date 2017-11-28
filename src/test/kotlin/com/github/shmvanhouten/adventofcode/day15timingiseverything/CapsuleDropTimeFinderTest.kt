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

    @Test
    fun `it should time that pressing the button at t=5 gives the capsule`() {
        val finder = CapsuleDropTimeFinder()
        var discMachine = DiscMachine()
        discMachine = discMachine.addDisc(Disc(amountOfPossiblePositions = 5, currentPosition = 4))
        discMachine = discMachine.addDisc(Disc(amountOfPossiblePositions = 2, currentPosition = 1))
        assertThat(finder.findTimeToPressButton(discMachine), equalTo(5))
    }

    @Test
    fun `it should solve the challenge input`() {
        val finder = CapsuleDropTimeFinder()

        val builder = DiscMachineBuilder()
        val rawInput = """Disc #1 has 5 positions; at time=0, it is at position 2.
Disc #2 has 13 positions; at time=0, it is at position 7.
Disc #3 has 17 positions; at time=0, it is at position 10.
Disc #4 has 3 positions; at time=0, it is at position 2.
Disc #5 has 19 positions; at time=0, it is at position 9.
Disc #6 has 7 positions; at time=0, it is at position 0."""

        val discMachine = builder.build(rawInput)

        assertThat(finder.findTimeToPressButton(discMachine), equalTo(148737))
    }

    @Test
    fun `it should solve the challenge input part 2`() {
        val finder = CapsuleDropTimeFinder()

        val builder = DiscMachineBuilder()
        val rawInput = """Disc #1 has 5 positions; at time=0, it is at position 2.
Disc #2 has 13 positions; at time=0, it is at position 7.
Disc #3 has 17 positions; at time=0, it is at position 10.
Disc #4 has 3 positions; at time=0, it is at position 2.
Disc #5 has 19 positions; at time=0, it is at position 9.
Disc #6 has 7 positions; at time=0, it is at position 0."""

        var discMachine = builder.build(rawInput)
        discMachine = discMachine.addDisc(Disc(11, 0))

        assertThat(finder.findTimeToPressButton(discMachine), equalTo(2353212))
    }

}