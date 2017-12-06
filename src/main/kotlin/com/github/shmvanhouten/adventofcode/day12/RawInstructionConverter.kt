package com.github.shmvanhouten.adventofcode.day12

import com.github.shmvanhouten.adventofcode.day12.instruction.*
import com.github.shmvanhouten.adventofcode.day12.instruction.InstructionType.*
import com.github.shmvanhouten.adventofcode.day23assembunny2point0.instruction.ToggleInstruction

class RawInstructionConverter {

    fun convertRawInstructionToInstructionList(rawInstructions: String): List<Instruction> {
        return rawInstructions
                .split("\n")
                .map { convertToInstruction(it.split(" ")) }
    }

    private fun convertToInstruction(rawInstruction: List<String>): Instruction {
        return when (getInstructionTypeFromRawInstruction(rawInstruction[0])) {
            CPY -> buildCopyInstruction(rawInstruction)
            INC -> buildIncInstruction(rawInstruction)
            DEC -> buildDecInstruction(rawInstruction)
            JUMP -> buildJumpInstruction(rawInstruction)
            TOGGLE -> buildToggleInstruction(rawInstruction)
        }

    }

    private fun buildToggleInstruction(rawInstruction: List<String>): Instruction {
        val registerToGetValueFrom = getRegisterFromRawInstruction(rawInstruction[1])!!

        return ToggleInstruction(registerToGetValueFrom)
    }

    private fun buildJumpInstruction(rawInstruction: List<String>): Instruction {
        val valueToCheck = getRegisterFromRawInstruction(rawInstruction[1])
        val valueToJump = getRegisterFromRawInstruction(rawInstruction[2])

        return if (valueToCheck == null) {
            if (valueToJump == null) {
                JumpAlwaysInstruction(rawInstruction[2].toInt())
            } else {
                JumpByRegisterAmountInstruction(rawInstruction[1].toInt(), valueToJump)
            }
        } else {
            if (valueToJump == null) {
                JumpDependentOnRegisterInstruction(valueToCheck, rawInstruction[2].toInt())
            }else{
                JumpDependentOnRegisterByRegisterAmountInstruction(valueToCheck, valueToJump)
            }

        }
    }

    private fun buildDecInstruction(rawInstruction: List<String>): Instruction {
        val registerToDecrement = getRegisterFromRawInstruction(rawInstruction[1])!!

        return DecrementInstruction(registerToDecrement)
    }

    private fun buildIncInstruction(rawInstruction: List<String>): Instruction {
        val registerToInc = getRegisterFromRawInstruction(rawInstruction[1])!!

        return IncrementInstruction(registerToInc)
    }

    private fun buildCopyInstruction(rawInstruction: List<String>): Instruction {
        val registerToSet = getRegisterFromRawInstruction(rawInstruction[2])!!
        val valueToCopy = getRegisterFromRawInstruction(rawInstruction[1])
        return if (valueToCopy == null) {
            CopyConstantInstruction(rawInstruction[1].toInt(), registerToSet)
        } else {
            CopyRegisterInstruction(valueToCopy, registerToSet)
        }
    }
}