package com.github.shmvanhouten.adventofcode.day21letterscramble

import com.github.shmvanhouten.adventofcode.day21letterscramble.instructions.*

class ScrambleInstructionConverter: InstructionConverter() {

    override fun buildRotateBasedOnPosition(splitInstruction: List<String>): Instruction {
        val charToBaseAmountToMoveOn = splitInstruction[6].toChar()
        return RotateRightBasedOnPositionInstruction(charToBaseAmountToMoveOn)

    }

    override fun buildMovePosition(splitInstruction: List<String>): Instruction {
        val indexOfCharToRemove = splitInstruction[2].toInt()
        val positionToMoveTo = splitInstruction[5].toInt()
        return MovePositionInstruction(indexOfCharToRemove, positionToMoveTo)
    }

    override fun buildInstructionBasedOnRotateRight(splitInstruction: List<String>): Instruction {
        val amountToRotate = splitInstruction[2].toInt()
        return RotateRightBasedOnAmountToRotateInstruction(amountToRotate)
    }

    override fun buildInstructionBasedOnRotateLeft(splitInstruction: List<String>): Instruction {
        val amountToRotate = splitInstruction[2].toInt()
        return RotateLeftInstruction(amountToRotate)
    }


}

internal fun String.toChar(): Char {
    return this[0]
}
