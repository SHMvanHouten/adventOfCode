package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class CopyConstantInstruction(registerToSet: Register, private val amount: Int) : CopyInstruction(registerToSet) {

    override fun getAmountToSet(state: BunnyState): Int {
        return amount
    }
}