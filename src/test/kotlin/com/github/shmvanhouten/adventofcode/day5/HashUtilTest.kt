package com.github.shmvanhouten.adventofcode.day5

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class HashUtilTest {

    @Test
    fun `for the input abc3231929 it should give a 1`() {
        val hashUtil = HashUtil()
        assertThat(hashUtil.get00000xHashMd5("abc3231929"), equalTo('1'))
    }

    @Test
    fun `for the input abc3231928 it should not return a value`() {
        val hashUtil = HashUtil()
        val isCharNull = hashUtil.get00000xHashMd5("abc3231928") == null
        assertThat(isCharNull, equalTo(true))
    }


    @Test
    fun `for the input abc5017308 it should give an 8`() {
        val hashUtil = HashUtil()
        assertThat(hashUtil.get00000xHashMd5("abc5017308"), equalTo('8'))
    }

    @Test
    fun `for the input abc5278568 it should give an f`() {
        val hashUtil = HashUtil()
        assertThat(hashUtil.get00000xHashMd5("abc5278568"), equalTo('f'))
    }

}