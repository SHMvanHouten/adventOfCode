package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

class SwapPositionInstruction(private val position1: Int, private val position2: Int) : SwapInstruction() {

    override fun executeInstruction(password: CharArray): CharArray {
        val charInPosition1 = password[position1]
        val charInPosition2 = password[position2]
        return swapCharacters(charInPosition1, charInPosition2, position1, position2, password)
    }
}