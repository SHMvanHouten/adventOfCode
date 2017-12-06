package com.github.shmvanhouten.adventofcode.day23assembunny2point0.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState
import com.github.shmvanhouten.adventofcode.day12.instruction.Instruction
import com.github.shmvanhouten.adventofcode.day12.instruction.Register

abstract class BrokenCopyInstruction: Instruction {
    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        return Pair(index + 1, state)
    }
}

class BrokenCopyWhichTurnsIntoJumpDependentOnRegisterInstruction(val registerToCheck: Register, val amountToJump: Int): BrokenCopyInstruction()

class BrokenCopyWhichTurnsIntoJumpAlwaysInstruction(val amountToJump: Int): BrokenCopyInstruction()