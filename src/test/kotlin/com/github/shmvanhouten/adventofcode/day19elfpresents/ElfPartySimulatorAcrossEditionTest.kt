package com.github.shmvanhouten.adventofcode.day19elfpresents

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class ElfPartySimulatorAcrossEditionTest {

    @Test
    fun `it should find that elf number 2 will get all the presents of the 5`() {
        val elfPartySimulator = ElfPartySimulatorAcrossEdition()
        assertThat(elfPartySimulator.getLuckyElf(5), equalTo(2))
    }


    @Test
    fun `it should find that elf number 7 will get all the presents of the 8`() {
        val elfPartySimulator = ElfPartySimulatorAcrossEdition()
        assertThat(elfPartySimulator.getLuckyElf(8), equalTo(7))
    }

    @Test
    fun `it should find that elf number 6 will get all the presents of the 12`() {
        val elfPartySimulator = ElfPartySimulatorAcrossEdition()
        assertThat(elfPartySimulator.getLuckyElf(12), equalTo(6))
    }



    @Test
    fun `it should find that elf number 3 will get all the presents of the 3018458`() {
        val elfPartySimulator = ElfPartySimulatorAcrossEdition()
        val luckyElf = elfPartySimulator.getLuckyElf(3018458)
        println(luckyElf)
        assertThat(luckyElf, equalTo(1424135))
    }



}