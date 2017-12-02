package com.github.shmvanhouten.adventofcode.day21letterscramble

import com.github.shmvanhouten.adventofcode.day21letterscramble.instructions.*
import com.github.shmvanhouten.adventofcode.day21letterscramble.instructions.InstructionType.*

abstract class InstructionConverter {
    fun convertRawInstructionToInstructionList(rawInstructions: String): List<Instruction> {
        return rawInstructions
                .split("\n")
                .map { convertToInstruction(it) }
    }

    private fun convertToInstruction(rawInstruction: String): Instruction {
        val splitInstruction = rawInstruction.split(" ")
        return when (getInstructionTypeFromRawInstruction(rawInstruction)) {
            SWAP_POSITION -> buildSwapPositionInstruction(splitInstruction)
            SWAP_LETTER -> buildSwapLetter(splitInstruction)
            REVERSE_POSITIONS -> buildReversePositions(splitInstruction)
            ROTATE_LEFT -> buildInstructionBasedOnRotateLeft(splitInstruction)
            ROTATE_RIGHT -> buildInstructionBasedOnRotateRight(splitInstruction)
            ROTATE_BASED_ON_POSITION -> buildRotateBasedOnPosition(splitInstruction)
            MOVE_POSITION -> buildMovePosition(splitInstruction)
        }
    }
    abstract fun buildRotateBasedOnPosition(splitInstruction: List<String>): Instruction

    abstract fun buildMovePosition(splitInstruction: List<String>): Instruction

    abstract fun buildInstructionBasedOnRotateRight(splitInstruction: List<String>): Instruction

    abstract fun buildInstructionBasedOnRotateLeft(splitInstruction: List<String>): Instruction

    private fun buildReversePositions(splitInstruction: List<String>): Instruction {
        val startIndex = splitInstruction[2].toInt()
        val endIndex = splitInstruction[4].toInt()
        return ReversePositionsInstruction(startIndex, endIndex)
    }

    private fun buildSwapLetter(splitInstruction: List<String>): Instruction {

        val char1 = splitInstruction[2].toChar()
        val char2 = splitInstruction[5].toChar()
        return SwapLetterInstruction(char1, char2)
    }

    private fun buildSwapPositionInstruction(splitInstruction: List<String>): Instruction {

        val position1 = splitInstruction[2].toInt()
        val position2 = splitInstruction[5].toInt()
        return SwapPositionInstruction(position1, position2)
    }

}