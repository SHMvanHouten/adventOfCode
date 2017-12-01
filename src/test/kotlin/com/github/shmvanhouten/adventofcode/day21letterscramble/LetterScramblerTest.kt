package com.github.shmvanhouten.adventofcode.day21letterscramble

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class LetterScramblerTest {

    @Test
    fun `it should swap the b in position 1 with the d in position 7`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "swap position 7 with position 1"
        val password = "abcdefgh"
        assertThat(scrambler.scramblePassword(rawInstructions, password), equalTo("ahcdefgb"))
    }

    @Test
    fun `it should swap the e with the d`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "swap letter e with letter d"
        val password = "abcdefgh"
        assertThat(scrambler.scramblePassword(rawInstructions, password), equalTo("abcedfgh"))
    }

    @Test
    fun `it should reverse the first five letters `() {
        val scrambler = LetterScrambler()
        val rawInstructions = "reverse positions 0 through 4"
        val password = "abcdefgh"
        assertThat(scrambler.scramblePassword(rawInstructions, password), equalTo("edcbafgh"))
    }


}