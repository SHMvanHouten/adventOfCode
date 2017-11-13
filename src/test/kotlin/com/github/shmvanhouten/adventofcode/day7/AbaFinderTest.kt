package com.github.shmvanhouten.adventofcode.day7

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class AbaFinderTest {

    @Test
    fun `it should find an abba inside the string "aba"`() {
        val abaFinder = AbaFinder()
        val allAbasFromString = abaFinder.getAllAbasFromString("aba")
        assertThat(allAbasFromString[0], equalTo("aba"))
    }

    @Test
    fun `it should find no abba inside the string "aaa"`() {
        val abaFinder = AbaFinder()
        assertThat(abaFinder.getAllAbasFromString("aaa").isEmpty(), equalTo(true))
    }

    @Test
    fun `it should find no abba inside the string "aab"`() {
        val abaFinder = AbaFinder()
        assertThat(abaFinder.getAllAbasFromString("aab").isEmpty(), equalTo(true))
    }


}