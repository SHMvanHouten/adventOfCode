package com.github.shmvanhouten.adventofcode.day14

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class PadKeyConstructorTest {

    @Test
    fun `it should construct 1 padKey`() {
        val constructor = PadKeyConstructor()
        val keys = constructor.getKeys(amount = 10, salt = "abc")
        assertThat(keys[0].index, equalTo(39))
    }

    @Test
    fun `it should find the 64th hash for the abc input`() {
        val constructor = PadKeyConstructor()
        val keys = constructor.getKeys(amount = 74, salt = "abc")
        assertThat(keys[63].index, equalTo(22728))
    }

    @Test
    fun `it should find the 64th hash for the challenge input`() {
        val constructor = PadKeyConstructor()
        val keys = constructor.getKeys(amount = 64, salt = "zpqevtbw")
        assertThat(keys[63].index, equalTo(16106))
    }

}