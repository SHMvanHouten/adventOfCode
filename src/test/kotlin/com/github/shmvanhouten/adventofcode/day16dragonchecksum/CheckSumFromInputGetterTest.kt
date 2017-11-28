package com.github.shmvanhouten.adventofcode.day16dragonchecksum

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class CheckSumFromInputGetterTest {

    @Test
    fun `it should get the checksum 01100 from input 10000`() {
        val checkSumFromInputGetter = CheckSumFromInputGetter()
        assertThat(checkSumFromInputGetter.getCheckSum("10000", 20), equalTo("01100"))
    }

    @Test
    fun `it should solve the challenge input and get the checksum 10010010110011010 from input 01000100010010111`() {
        val checkSumFromInputGetter = CheckSumFromInputGetter()
        assertThat(checkSumFromInputGetter.getCheckSum("01000100010010111", 272), equalTo("10010010110011010"))
    }



}