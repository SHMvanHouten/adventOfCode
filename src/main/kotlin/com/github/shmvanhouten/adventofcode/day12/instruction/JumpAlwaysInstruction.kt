package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

class JumpAlwaysInstruction(val amountToJump: Int): JumpInstruction() {

    override fun getAmountToJump(state: BunnyState): Int {
        return if (amountToJump == 0){
            1
        }else {
           amountToJump
        }
    }

}