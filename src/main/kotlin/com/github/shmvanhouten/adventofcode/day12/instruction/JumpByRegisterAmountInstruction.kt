package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class JumpByRegisterAmountInstruction(val checkInt: Int, val registerHoldingAmountToJump: Register): JumpInstruction() {
    override fun getAmountToJump(state: BunnyState): Int {
        return if(checkInt == 0) {
            1
        } else {
            state.get(registerHoldingAmountToJump)
        }
    }
}