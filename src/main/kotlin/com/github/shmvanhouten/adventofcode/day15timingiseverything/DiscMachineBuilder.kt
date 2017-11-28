package com.github.shmvanhouten.adventofcode.day15timingiseverything

class DiscMachineBuilder {
    fun build(rawInput: String): DiscMachine {
        var discMachine = DiscMachine()

        val instructionList = rawInput.split("\n")
        for (instruction in instructionList) {
            discMachine = discMachine.addDisc(buildDiscFromInstruction(instruction))
        }

        return discMachine
    }

    private fun buildDiscFromInstruction(instruction: String): Disc {
        val splitInstruction = instruction.split(" ")
        val amountOfPossiblePositions = splitInstruction[3].toInt()
        val currentPosition = splitInstruction[11].substring(0, splitInstruction[11].lastIndex).toInt()
        return Disc(amountOfPossiblePositions, currentPosition)
    }
}