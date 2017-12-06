package com.github.shmvanhouten.adventofcode.day23assembunny2point0.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState
import com.github.shmvanhouten.adventofcode.day12.instruction.*

class ToggleInstruction(val registerToGetValueFrom: Register) : Instruction {
    override fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState> {
        return Pair(index + 1, state)
    }

    fun getIndexOfInstructionToToggle(state: BunnyState, index: Int): Int {
        return index + state.get(registerToGetValueFrom)
    }

    fun changeInstruction(instruction: Instruction): Instruction {
        return when (instruction) {
            is DecrementInstruction -> IncrementInstruction(instruction.registerToDecrement)
            is ToggleInstruction -> IncrementInstruction(instruction.registerToGetValueFrom)
            is IncrementInstruction -> DecrementInstruction(instruction.registerToIncrement)
            is JumpDependentOnRegisterInstruction -> BrokenCopyWhichTurnsIntoJumpDependentOnRegisterInstruction(instruction.registerToCheck, instruction.amountToJump)
            is JumpAlwaysInstruction -> BrokenCopyWhichTurnsIntoJumpAlwaysInstruction(instruction.amountToJump)
            is JumpByRegisterAmountInstruction -> CopyConstantInstruction(instruction.checkInt, instruction.registerHoldingAmountToJump)
            is JumpDependentOnRegisterByRegisterAmountInstruction -> CopyRegisterInstruction(instruction.registerToCheck, instruction.registerToGetAmountFrom)
            is CopyConstantInstruction -> JumpByRegisterAmountInstruction(instruction.amount, instruction.registerToSet)
            is CopyRegisterInstruction -> JumpDependentOnRegisterByRegisterAmountInstruction(instruction.registerToCopy, instruction.registerToSet)
            is BrokenCopyWhichTurnsIntoJumpDependentOnRegisterInstruction -> JumpDependentOnRegisterInstruction(instruction.registerToCheck, instruction.amountToJump)
            is BrokenCopyWhichTurnsIntoJumpAlwaysInstruction -> JumpAlwaysInstruction(instruction.amountToJump)
            else ->{
                println("something went wrong, Instruction not in when loop")
                return IncrementInstruction(Register.A)
            }
        }
    }
}