package com.github.shmvanhouten.adventofcode.day7

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class AbaFinderTest {

    @Test
    fun `it should find a bab from the string "aba"`() {
        val abaFinder = AbaFinder()
        val allAbasFromString = abaFinder.getAllPotentialBabsFromSequence("aba")
        assertThat(allAbasFromString[0], equalTo("bab"))
    }

    @Test
    fun `it should find no abba inside the string "aaa"`() {
        val abaFinder = AbaFinder()
        assertThat(abaFinder.getAllPotentialBabsFromSequence("aaa").isEmpty(), equalTo(true))
    }

    @Test
    fun `it should find no abba inside the string "aab"`() {
        val abaFinder = AbaFinder()
        assertThat(abaFinder.getAllPotentialBabsFromSequence("aab").isEmpty(), equalTo(true))
    }


}