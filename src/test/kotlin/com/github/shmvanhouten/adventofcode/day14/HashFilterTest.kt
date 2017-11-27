package com.github.shmvanhouten.adventofcode.day14

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class HashFilterTest {

    @Test
    fun `it should get the first hash that contains three of the same character in a row`() {
        val hashFilter = HashFilter()
        val possiblePadKey: PadKey = hashFilter.getNext(0, "abc")
        assertThat(possiblePadKey.index, equalTo(18))
    }
}