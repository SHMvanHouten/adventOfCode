package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class ElfPartySimulatorAcrossImplTest {

    @Test
    fun `it should find that elf number 2 will get all the presents of the 5`() {
        val elfCircleBuilder = DoubleLinkedElfCircleBuilder()
        val elfPartySimulator = ElfPartySimulatorAcrossImpl(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(5).number, equalTo(2))
    }


    @Test
    fun `it should find that elf number 7 will get all the presents of the 8`() {
        val elfCircleBuilder = DoubleLinkedElfCircleBuilder()
        val elfPartySimulator = ElfPartySimulatorAcrossImpl(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(8).number, equalTo(7))
    }

    @Test
    fun `it should find that elf number 6 will get all the presents of the 12`() {
        val elfCircleBuilder = DoubleLinkedElfCircleBuilder()
        val elfPartySimulator = ElfPartySimulatorAcrossImpl(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(12).number, equalTo(3))
    }

    @Test
    fun `it should find that elf number 1 will get all the presents of the 4`() {
        val elfCircleBuilder = DoubleLinkedElfCircleBuilder()
        val elfPartySimulator = ElfPartySimulatorAcrossImpl(elfCircleBuilder)
        assertThat(elfPartySimulator.getLuckyElf(4).number, equalTo(1))
    }

    @Test
    fun `it should find that elf number 1424135 will get all the presents of the 3018458`() {
        val elfCircleBuilder = DoubleLinkedElfCircleBuilder()
        val elfPartySimulator = ElfPartySimulatorAcrossImpl(elfCircleBuilder)
        val luckyElf = elfPartySimulator.getLuckyElf(3018458)
        assertThat(luckyElf.number, equalTo(1424135))
    }
}