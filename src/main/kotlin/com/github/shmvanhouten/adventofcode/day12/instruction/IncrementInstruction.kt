package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class IncrementInstruction(private val registerToIncrement: Register): Instruction {

    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        val newBunnyState = state.inc(registerToIncrement)

        return Pair(index + 1, newBunnyState)
    }
}