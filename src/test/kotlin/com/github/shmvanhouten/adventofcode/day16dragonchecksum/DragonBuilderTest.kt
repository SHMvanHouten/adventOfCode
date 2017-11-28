package com.github.shmvanhouten.adventofcode.day16dragonchecksum

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class DragonBuilderTest {

    @Test
    fun `it should dragonify the input until it reaches 20 characters`() {
        val dragonBuilder = DragonBuilder()
        val result = dragonBuilder.build("0000000000", 20)
        assertThat(result, equalTo("00000000000111111111"))
    }

    @Test
    fun `10000 should build to 10000011110010000111`() {
        val dragonBuilder = DragonBuilder()
        val result = dragonBuilder.build("10000", 20)
        assertThat(result, equalTo("10000011110010000111"))
    }
}