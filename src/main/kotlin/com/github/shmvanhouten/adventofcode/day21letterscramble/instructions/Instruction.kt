package com.github.shmvanhouten.adventofcode.day21letterscramble.instructions

interface Instruction {
    fun executeInstruction(password: CharArray): CharArray
}

enum class InstructionType(val rawInstructionPart: String) {
    SWAP_POSITION("swap position"),
    SWAP_LETTER("swap letter"),
    ROTATE_LEFT("rotate left"),
    ROTATE_RIGHT("rotate right"),
    ROTATE_BASED_ON_POSITION("rotate based on position"),
    REVERSE_POSITIONS("reverse positions"),
    MOVE_POSITION("move position")
}

fun getInstructionTypeFromRawInstruction(rawInstruction: String): InstructionType {
    return InstructionType.values().find { rawInstruction.contains(it.rawInstructionPart) }!!
}