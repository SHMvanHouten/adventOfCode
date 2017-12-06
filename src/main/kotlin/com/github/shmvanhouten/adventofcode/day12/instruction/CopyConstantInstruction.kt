package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class CopyConstantInstruction(val amount: Int, registerToSet: Register) : CopyInstruction(registerToSet) {

    override fun getAmountToSet(state: BunnyState): Int {
        return amount
    }
}