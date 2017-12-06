package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

abstract class JumpInstruction : Instruction {

    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        val actualAmountToJump = getAmountToJump(state)

        return Pair(index + actualAmountToJump, state)
    }

    abstract fun getAmountToJump(state: BunnyState): Int
}