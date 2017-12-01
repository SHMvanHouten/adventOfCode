package com.github.shmvanhouten.adventofcode.day21letterscramble

import com.github.shmvanhouten.adventofcode.day21letterscramble.instructions.*
import com.github.shmvanhouten.adventofcode.day21letterscramble.instructions.InstructionType.*

class ScrambleInstructionConverter {
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
            else -> SwapPositionInstruction(0, 0)
        }
    }

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

private fun String.toChar(): Char {
    return this[0]
}
