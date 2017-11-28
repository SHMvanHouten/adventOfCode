package com.github.shmvanhouten.adventofcode.day16dragonchecksum

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class CheckSumBuilderTest {

    @Test
    fun `it should make a checksum from the input`() {
        val checkSumBuilder = CheckSumBuilder()
        val input = "10000011110010000111"
        assertThat(checkSumBuilder.buildCheckSum(input), equalTo("01100"))
    }
}