package com.github.shmvanhouten.adventofcode.day21letterscramble

class Size8PasswordLetterDescrambler(private val instructionBuilder: DescrambleInstructionConverter = DescrambleInstructionConverter()) {

    fun descramblePassword(rawInstructions: String, password: String): String {
        val instructions = instructionBuilder.convertRawInstructionToInstructionList(rawInstructions).reversed()

        return instructions
                .fold(password.toCharArray()) {  scrambledPassword, element -> element.executeInstruction(scrambledPassword) }
                .joinToString("")
    }
}