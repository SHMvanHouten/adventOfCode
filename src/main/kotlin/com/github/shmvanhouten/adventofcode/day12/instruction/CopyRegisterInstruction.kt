package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class CopyRegisterInstruction(val registerToCopy: Register, registerToSet: Register) : CopyInstruction(registerToSet) {

    override fun getAmountToSet(state: BunnyState) = state.get(registerToCopy)

}