package com.github.shmvanhouten.adventofcode.day12

import com.github.shmvanhouten.adventofcode.day12.instruction.*
import com.github.shmvanhouten.adventofcode.day12.instruction.InstructionType.*

class RawInstructionConverter {

    fun convertRawInstructionToInstructionList(rawInstructions: String): List<Instruction> {
        return rawInstructions
                .split("\n")
                .map { convertToInstruction(it.split(" ")) }
    }

    private fun convertToInstruction(rawInstruction: List<String>): Instruction {
        return when (getInstructionTypeFromRawInstruction(rawInstruction[0])){
            CPY -> buildCopyInstruction(rawInstruction)
            INC -> buildIncInstruction(rawInstruction)
            DEC -> buildDecInstruction(rawInstruction)
            JUMP -> buildJumpInstruction(rawInstruction)
        }

    }

    private fun buildJumpInstruction(rawInstruction: List<String>): Instruction {
        val amountToJump = rawInstruction[2].toInt()
        val valueToCheck = getRegisterFromRawInstruction(rawInstruction[1])

        return if(valueToCheck == null){
            if(rawInstruction[1].toInt() == 0) JumpInstruction(1)
            else JumpInstruction(amountToJump)
        } else {
            JumpDependentOnRegisterInstruction(valueToCheck, amountToJump)
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
        return if(valueToCopy == null){
            CopyConstantInstruction(registerToSet, rawInstruction[1].toInt())
        } else {
            CopyRegisterInstruction(registerToSet, valueToCopy)
        }
    }
}