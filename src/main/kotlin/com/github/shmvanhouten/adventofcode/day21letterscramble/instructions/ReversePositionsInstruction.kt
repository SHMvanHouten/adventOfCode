package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

class ReversePositionsInstruction(private val startIndex: Int, private val endIndex: Int): Instruction {
    override fun executeInstruction(password: CharArray): CharArray {
        val beforeReversedPart = password.sliceArray(0.until(startIndex))
        val reversedPart = password.sliceArray(startIndex..endIndex).reversedArray()
        val afterReversedPart = password.sliceArray((endIndex + 1)..password.lastIndex)
        return beforeReversedPart
                .plus(reversedPart)
                .plus(afterReversedPart)
    }
}