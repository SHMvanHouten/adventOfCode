package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class DecrementInstruction(private val registerToDecrement: Register): Instruction {

    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        val newBunnyState = state.dec(registerToDecrement)

        return Pair(index + 1, newBunnyState)
    }
}