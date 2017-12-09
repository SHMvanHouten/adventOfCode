package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class OutInstruction(val registerToOutput: Register): Instruction {

    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        println(state.get(registerToOutput))
        return Pair(index + 1, state)
    }
}