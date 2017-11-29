package com.github.shmvanhouten.adventofcode.day19elfpresents

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Ignore
import org.junit.Test

class ElfPartySimulatorTest {

    @Test
    fun `it should find that elf number 3 will get all the presents of the 5`() {
        val elfPartySimulator = ElfPartySimulator()
        assertThat(elfPartySimulator.getLuckyElf(5), equalTo(3))
    }

    @Test
    fun `it should find that elf number 5 will get all the presents of the 10`() {
        val elfPartySimulator = ElfPartySimulator()
        assertThat(elfPartySimulator.getLuckyElf(10), equalTo(5))
    }

    @Test
    fun `it should find that elf number 1 will get all the presents of the 32`() {
        val elfPartySimulator = ElfPartySimulator()
        assertThat(elfPartySimulator.getLuckyElf(32), equalTo(1))
    }

    @Test
    fun `it should find that elf number 17 will get all the presents of the 20`() {
        val elfPartySimulator = ElfPartySimulator()
        assertThat(elfPartySimulator.getLuckyElf(20), equalTo(9))
    }


    @Test
    fun `it should find which elf gets all the presents for the challenge input number of elves, 3018458`() {
        val elfPartySimulator = ElfPartySimulator()
        assertThat(elfPartySimulator.getLuckyElf(3018458), equalTo(3))
    }


}