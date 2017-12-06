package com.github.shmvanhouten.adventofcode.day12.instruction

import com.github.shmvanhouten.adventofcode.day12.BunnyState

interface Instruction {
    fun executeInstruction(index: Int, state: BunnyState): Pair<Int, BunnyState>
}

enum class Register(val rawInstructionPart: String) {
    A("a"),
    B("b"),
    C("c"),
    D("d")

}
internal fun getRegisterFromRawInstruction(rawInstruction: String): Register? {
    return Register.values().find { rawInstruction == it.rawInstructionPart }
}

enum class InstructionType(val rawInstructionPart: String){
    CPY("cpy"),
    INC("inc"),
    DEC("dec"),
    JUMP("jnz"),
    TOGGLE("tgl")
}

internal fun getInstructionTypeFromRawInstruction(rawInstruction: String): InstructionType {
    return InstructionType.values().find { rawInstruction.contains(it.rawInstructionPart) }!!
}