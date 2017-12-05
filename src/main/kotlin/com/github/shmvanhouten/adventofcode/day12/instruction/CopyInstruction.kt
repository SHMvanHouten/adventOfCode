package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

abstract class CopyInstruction(private val registerToSet: Register): Instruction {

    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        val valueOfRegisterToCopy = getAmountToSet(state)
        val newBunnyState = state.setRegister(registerToSet, valueOfRegisterToCopy)

        return Pair(index + 1, newBunnyState)
    }

    abstract fun getAmountToSet(state: BunnyState): Int
}