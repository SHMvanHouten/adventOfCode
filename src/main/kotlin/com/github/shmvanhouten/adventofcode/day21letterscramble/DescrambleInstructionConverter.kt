package com.github.shmvanhouten.adventofcode.day21letterscramble

import com.github.shmvanhouten.adventofcode.day21letterscramble.instructions.*

class DescrambleInstructionConverter: InstructionConverter() {
    override fun buildRotateBasedOnPosition(splitInstruction: List<String>): Instruction {
        val charToBaseAmountToMoveOn = splitInstruction[6].toChar()
        return RotateRightBasedOnPositionDecoderInstruction(charToBaseAmountToMoveOn)
    }

    override fun buildMovePosition(splitInstruction: List<String>): Instruction {
        val indexOfCharToRemove = splitInstruction[5].toInt()
        val positionToMoveTo = splitInstruction[2].toInt()
        return MovePositionInstruction(indexOfCharToRemove, positionToMoveTo)
    }

    override fun buildInstructionBasedOnRotateRight(splitInstruction: List<String>): Instruction {
        val amountToRotate = splitInstruction[2].toInt()
        return RotateLeftInstruction(amountToRotate)
    }

    override fun buildInstructionBasedOnRotateLeft(splitInstruction: List<String>): Instruction {
        val amountToRotate = splitInstruction[2].toInt()
        return RotateRightBasedOnAmountToRotateInstruction(amountToRotate)
    }

}