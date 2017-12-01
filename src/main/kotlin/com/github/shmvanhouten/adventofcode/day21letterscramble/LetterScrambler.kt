package com.github.shmvanhouten.adventofcode.day21letterscramble

class LetterScrambler (private val instructionBuilder: ScrambleInstructionConverter = ScrambleInstructionConverter()){
    fun scramblePassword(rawInstructions: String, password: String): String {
        val instructions = instructionBuilder.convertRawInstructionToInstructionList(rawInstructions)

        return instructions
                .fold(password.toCharArray()) { scrambledPassword, element -> element.executeInstruction(scrambledPassword) }
                .joinToString("")
    }
}