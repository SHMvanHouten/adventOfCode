package com.github.shmvanhouten.adventofcode.day25clocksignal

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class AssemBunnyClockSignalFinderTest {

    @Test
    fun `it should find the first value of a where the Output instruction will output 1010101 repeating`() {
        val clockSignalFinder = AssemBunnyClockSignalFinder()
        assertThat(clockSignalFinder.findValueOfARequiredForSignal(day25ChallengeInput), equalTo(182))
    }
}