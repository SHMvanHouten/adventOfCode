package com.github.shmvanhouten.adventofcode.day14

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class HashFilterTest {

    @Test
    fun `for the singeHashImpl it should get the first hash that contains three of the same character in a row`() {
        val hashFilter = HashFilterSingleHashImpl("abc")
        val possiblePadKey: PadKey = hashFilter.getNext(0)
        assertThat(possiblePadKey.index, equalTo(18))
    }

    @Test
    fun `for the 2016HashImpl it should get the first hash that contains three of the same chars in a row at index 5`() {
        val hashFilter = HashFilter2016HashImpl("abc")
        val possiblePadKey: PadKey = hashFilter.getNext(0)
        assertThat(possiblePadKey.index, equalTo(5))
    }
}