package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class JumpInstruction(private val amountToJump: Int): Instruction {

    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        return Pair(index + amountToJump, state)
    }
}