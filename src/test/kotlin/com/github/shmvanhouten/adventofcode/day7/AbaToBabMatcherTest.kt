package com.github.shmvanhouten.adventofcode.day7

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class AbaToBabMatcherTest {

    @Test
    fun `it should find a match in bab for aba`() {
        val abaToBabMatcher = AbaToBabMatcher()
        val hypernetSequence = "bab"
        val abaList = listOf<String>("aba")
        assertThat(abaToBabMatcher.findBabMatchesInSequenceForAbas(hypernetSequence, abaList), equalTo(true))
    }

    @Test
    fun `it should not find a match in aab for aba`() {
        val abaToBabMatcher = AbaToBabMatcher()
        val hypernetSequence = "aab"
        val abaList = listOf<String>("aba")
        assertThat(abaToBabMatcher.findBabMatchesInSequenceForAbas(hypernetSequence, abaList), equalTo(false))
    }

}