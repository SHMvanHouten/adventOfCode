package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class JumpDependentOnRegisterInstruction(private val registerToCheck: Register, private val amountToJump: Int): Instruction {
    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        return if(state.get(registerToCheck) == 0){
            Pair(index + 1, state)
        } else {
            Pair(index + amountToJump, state)
        }
    }
}