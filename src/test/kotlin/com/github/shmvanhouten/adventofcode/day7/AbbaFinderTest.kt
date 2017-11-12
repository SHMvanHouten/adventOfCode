package com.github.shmvanhouten.adventofcode.day7

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class AbbaFinderTest {

    @Test
    fun `it should find an abba inside the string "abba"`() {
        val abbaFinder = AbbaFinder()
        assertThat(abbaFinder.doesStringContainAbba("abba"), equalTo(true))
    }

    @Test
    fun `it should find an abba inside the string "abca"`() {
        val abbaFinder = AbbaFinder()
        assertThat(abbaFinder.doesStringContainAbba("abca"), equalTo(false))
    }

    @Test
    fun `it should find an abba inside the string "cdsawerdsf"`() {
        val abbaFinder = AbbaFinder()
        assertThat(abbaFinder.doesStringContainAbba("cdsawerdsf"), equalTo(false))
    }

    @Test
    fun `it should find an abba inside the string "asdffsfaabbasfww"`() {
        val abbaFinder = AbbaFinder()
        assertThat(abbaFinder.doesStringContainAbba("asdffsfaabbasfw"), equalTo(true))
    }

    @Test
    fun `it should not find an abba inside the string "aaaa"`() {
        val abbaFinder = AbbaFinder()
        assertThat(abbaFinder.doesStringContainAbba("aaaa"), equalTo(false))
    }

    @Test
    fun `it should not find an abba inside the string "zztuumdsokfgtof"`() {
        val abbaFinder = AbbaFinder()
        assertThat(abbaFinder.doesStringContainAbba("zztuumdsokfgtof"), equalTo(false))
    }

}