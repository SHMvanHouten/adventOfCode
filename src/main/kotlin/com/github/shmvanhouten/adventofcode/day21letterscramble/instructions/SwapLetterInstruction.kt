package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

class SwapLetterInstruction(private val char1: Char, private val char2: Char) : SwapInstruction() {
    override fun executeInstruction(password: CharArray): CharArray {
        val char1Index = password.indexOf(char1)
        val char2Index = password.indexOf(char2)
        return swapCharacters(char1, char2, char1Index, char2Index, password)
    }
}