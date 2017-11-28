package com.github.shmvanhouten.adventofcode.day16dragonchecksum

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class DragonifierTest {

    @Test
    fun `it should copy the 1 , switch it to a 0 and paste it on with a 0 between to get 100`() {
        val startingInput = "1"
        val dragonifier = Dragonifier()
        val result = dragonifier.dragonify(startingInput)
        assertThat(result, equalTo("100"))

    }

    @Test
    fun `it should copy the 0 , switch it to a 1 and paste it on with a 0 between to get 001`() {
        val startingInput = "0"
        val dragonifier = Dragonifier()
        val result = dragonifier.dragonify(startingInput)
        assertThat(result, equalTo("001"))

    }

    @Test
    fun `it should copy the 01  , reverse it to a 10, switch it to a 01 and paste it on with a 0 between to get 01001`() {
        val startingInput = "01"
        val dragonifier = Dragonifier()
        val result = dragonifier.dragonify(startingInput)
        assertThat(result, equalTo("01001"))
    }

    @Test
    fun `it should copy the input, reverse the copy, switch its value an paste it to the original with a 0 between for 11111 becomes 11111000000`() {
        val startingInput = "11111"
        val dragonifier = Dragonifier()
        val result = dragonifier.dragonify(startingInput)
        assertThat(result, equalTo("11111000000"))
    }

    @Test
    fun `it should convert 111100001010 to 1111000010100101011110000`() {
        val startingInput = "111100001010"
        val dragonifier = Dragonifier()
        val result = dragonifier.dragonify(startingInput)
        assertThat(result, equalTo("1111000010100101011110000"))
    }   

}