package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class JumpDependentOnRegisterByRegisterAmountInstruction(val registerToCheck: Register, val registerToGetAmountFrom: Register): JumpInstruction() {
    override fun getAmountToJump(state: BunnyState): Int {
        return if (state.get(registerToCheck) == 0) {
            1
        } else {
            state.get(registerToGetAmountFrom)
        }
    }
}