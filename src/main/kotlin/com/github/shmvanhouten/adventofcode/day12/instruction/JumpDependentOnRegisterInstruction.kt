package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class JumpDependentOnRegisterInstruction(val registerToCheck: Register, val amountToJump: Int) : JumpInstruction() {

    override fun getAmountToJump(state: BunnyState): Int {
        return if (state.get(registerToCheck) == 0) {
            1
        } else {
            amountToJump
        }
    }
}