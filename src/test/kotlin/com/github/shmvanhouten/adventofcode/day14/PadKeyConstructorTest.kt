package com.github.shmvanhouten.adventofcode.day14

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class PadKeyConstructorTest {

    @Test
    fun `it should construct 1 padKey`() {
        val hashFilter = HashFilterSingleHashImpl("abc")
        val constructor = PadKeyConstructor(hashFilter)
        val keys = constructor.getKeys(10)
        assertThat(keys[0].index, equalTo(39))
    }

    @Test
    fun `it should find the 64th hash for the abc input`() {
        val hashFilter = HashFilterSingleHashImpl("abc")
        val constructor = PadKeyConstructor(hashFilter)
        val keys = constructor.getKeys(74)
        assertThat(keys[63].index, equalTo(22728))
    }

    @Test
    fun `it should find the 64th hash for the challenge input`() {
        val hashFilter = HashFilterSingleHashImpl("zpqevtbw")
        val constructor = PadKeyConstructor(hashFilter)
        val keys = constructor.getKeys(64)
        assertThat(keys[63].index, equalTo(16106))
    }

    @Test
    fun `it should find the 10th index hash to be the first key with the 2016 hashfilter`() {
        val hashFilter = HashFilter2016HashImpl("abc")
        val constructor = PadKeyConstructor(hashFilter)
        val keys = constructor.getKeys(10)
        assertThat(keys[0].index, equalTo(10))
    }

    @Test
    fun `it should find the 22551st index hash to be the 64th key with the 2016 hashfilter`() {
        val hashFilter = HashFilter2016HashImpl("abc")
        val constructor = PadKeyConstructor(hashFilter)
        val keys = constructor.getKeys(64)
        assertThat(keys[63].index, equalTo(22551))
    }

    @Test
    fun `it should find the index for the 64th key with the 2016 hashfilter for the challenge input`() {
        val hashFilter = HashFilter2016HashImpl("zpqevtbw")
        val constructor = PadKeyConstructor(hashFilter)
        val keys = constructor.getKeys(64)
        assertThat(keys[63].index, equalTo(22423))
    }




}