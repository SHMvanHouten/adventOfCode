package com.github.shmvanhouten.adventofcode.day21letterscramble

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class Size8PasswordLetterDescramblerTest {

    @Test
    fun `it should swap the b in position 1 with the d in position 7 and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "swap position 7 with position 1"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should swap the e in position 4 with the a in position 0 and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "swap position 4 with position 0"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should swap the e with the d and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "swap letter e with letter d"
        val password = "abcdefgh"
        assertThat(scrambler.scramblePassword(rawInstructions, password), equalTo("abcedfgh"))
    }

    @Test
    fun `it should swap the d with the b and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "swap letter d with letter b"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should reverse the first five letters  and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "reverse positions 0 through 4"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should reverse 3 letters  and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "reverse positions 1 through 4"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should shift all the letters one position to the left and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "rotate left 1 step"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should shift all the letters two positions to the left and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "rotate left 2 step"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should shift all the letters one position to the right and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "rotate right 1 step"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should remove letter at position 1 then append it at pos 4 and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "move position 1 to position 4"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should remove letter at position 3 then insert it in position 0 and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "move position 3 to position 0"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should shift the whole string to the right based on char position and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions = "rotate based on position of letter c"
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should scramble the password and descramble it again`() {
        val scrambler = LetterScrambler()
        val rawInstructions ="""rotate based on position of letter e
move position 3 to position 6
rotate based on position of letter b
move position 3 to position 0
move position 3 to position 0
rotate based on position of letter c"""
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should descramble the scrambled password of the part 1 challenge`() {
        val scrambler = LetterScrambler()
        val rawInstructions = day21ChallengeInput
        val password = "abcdefgh"
        val scrambledPassword = scrambler.scramblePassword(rawInstructions, password)
        val descrambler = Size8PasswordLetterDescrambler()
        assertThat(descrambler.descramblePassword(rawInstructions, scrambledPassword), equalTo("abcdefgh"))
    }

    @Test
    fun `it should solve the challenge input`() {
        val descrambler = Size8PasswordLetterDescrambler()
        val rawInstructions = day21ChallengeInput
        val scrambledPassword = "fbgdceah"
        val unscrambledPassword = descrambler.descramblePassword(rawInstructions, scrambledPassword)
        println(unscrambledPassword)

        val scrambler = LetterScrambler()
        assertThat(scrambler.scramblePassword(rawInstructions, unscrambledPassword), equalTo(scrambledPassword))
    }
}