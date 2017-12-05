package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class CopyRegisterInstruction(registerToSet: Register, private val registerToCopy: Register) : CopyInstruction(registerToSet) {

    override fun getAmountToSet(state: BunnyState) = state.get(registerToCopy)

}