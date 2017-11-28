package com.github.shmvanhouten.adventofcode.day15timingiseverything

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class DiscMachineBuilderTest  {

    @Test
    fun `it should build a machine from the raw input`() {
        val discMachineBuilder = DiscMachineBuilder()
        val input = """Disc #1 has 5 positions; at time=0, it is at position 4."""
        val discMachine: DiscMachine = discMachineBuilder.build(input)
        assertThat(discMachine.discs.getValue(1), equalTo(Disc(5, 4)))
    }

    @Test
    fun `it should build a machine from the raw multiLine input`() {
        val discMachineBuilder = DiscMachineBuilder()
        val input = """Disc #1 has 5 positions; at time=0, it is at position 4.
Disc #2 has 2 positions; at time=0, it is at position 1."""
        val discMachine: DiscMachine = discMachineBuilder.build(input)
        assertThat(discMachine.discs.size, equalTo(2))
        assertThat(discMachine.discs.getValue(2), equalTo(Disc(2, 1)))
    }


}