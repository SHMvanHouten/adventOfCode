package com.github.shmvanhouten.adventofcode.day19elfpresents.slowsolution

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Ignore
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
        assertThat(elfPartySimulator.getLuckyElf(12), equalTo(3))
    }

    @Test
    fun `it should find that elf number 1 will get all the presents of the 4`() {
        val elfPartySimulator = ElfPartySimulatorAcrossEdition()
        assertThat(elfPartySimulator.getLuckyElf(4), equalTo(1))
    }



    @Test@Ignore("takes about 10 minutes, the solution in the linkedelfsolution package takes 2 secs")
    fun `it should find that elf number 3 will get all the presents of the 3018458`() {
        val elfPartySimulator = ElfPartySimulatorAcrossEdition()
        val luckyElf = elfPartySimulator.getLuckyElf(3018458)
        println(luckyElf)
        assertThat(luckyElf, equalTo(1424135))
    }



}