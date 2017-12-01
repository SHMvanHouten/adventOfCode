package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

abstract class SwapInstruction : Instruction {
    override abstract fun executeInstruction(password: CharArray): CharArray

    fun swapCharacters(char1: Char, char2: Char, position1: Int, position2: Int, password: CharArray): CharArray {
        password[position1] = char2
        password[position2] = char1
        return password
    }
}