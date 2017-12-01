package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class LinkedElfPartySimulatorTest {
    @Test
    fun `it should find that elf number 3 will get all the presents of the 5`() {
        val elfCircleBuilder = ElfCircleBuilder()
        val elfPartySimulator = LinkedElfPartySimulator(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(5).number, equalTo(3))
    }

    @Test
    fun `it should find that elf number 5 will get all the presents of the 10`() {
        val elfCircleBuilder = ElfCircleBuilder()
        val elfPartySimulator = LinkedElfPartySimulator(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(10).number, equalTo(5))
    }

    @Test
    fun `it should find that elf number 1 will get all the presents of the 32`() {
        val elfCircleBuilder = ElfCircleBuilder()
        val elfPartySimulator = LinkedElfPartySimulator(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(32).number, equalTo(1))
    }

    @Test
    fun `it should find that elf number 17 will get all the presents of the 20`() {
        val elfCircleBuilder = ElfCircleBuilder()
        val elfPartySimulator = LinkedElfPartySimulator(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(20).number, equalTo(9))
    }
    @Test
    fun `it should find which elf gets all the presents for the challenge input number of elves, 3018458`() {
        val elfCircleBuilder = ElfCircleBuilder()
        val elfPartySimulator = LinkedElfPartySimulator(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(3018458).number, equalTo(1842613))
    }

}