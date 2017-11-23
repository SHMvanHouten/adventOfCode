package com.github.shmvanhouten.adventofcode.day12

import com.github.shmvanhouten.adventofcode.day12.Instruction.*
import com.github.shmvanhouten.adventofcode.day12.Register.A
import com.github.shmvanhouten.adventofcode.day12.Register.B
import com.github.shmvanhouten.adventofcode.day12.Register.C

class AssemBunnyCodeRunner {
    fun runInput(input: String): BunnyState {
        val instructions = input.split("\n").map { it.split(' ') }
        var state = BunnyState()
        for (instruction in instructions) {
            when(instruction[0]){
                CPY.value -> state = runCopyInstruction(instruction, state)
                INC.value -> state = runIncInstruction(instruction[1], state)
                DEC.value -> state = runDecInstruction(instruction[1], state)
            }
        }

        return state
    }

    private fun runDecInstruction(registerValue: String, state: BunnyState): BunnyState = when(registerValue){
        A.value -> state.decA()
        B.value -> state.decB()
        C.value -> state.decC()
        else -> state.decD()

    }

    private fun runIncInstruction(registerValue: String, state: BunnyState): BunnyState = when(registerValue){
        A.value -> state.incA()
        B.value -> state.incB()
        C.value -> state.incC()
        else -> state.incD()

    }

    private fun runCopyInstruction(instructionParts: List<String>, state: BunnyState): BunnyState = when (instructionParts[2]) {
        A.value -> state.setA(instructionParts[1].toInt())
        B.value -> state.setB(instructionParts[1].toInt())
        C.value -> state.setC(instructionParts[1].toInt())
        else -> state.setD(instructionParts[1].toInt())
    }
}

enum class Register(val value: String) {
    A("a"),
    B("b"),
    C("c")
}

enum class Instruction(val value: String){
    CPY("cpy"),
    INC("inc"),
    DEC("dec"),
    JUMP("jnz")
}