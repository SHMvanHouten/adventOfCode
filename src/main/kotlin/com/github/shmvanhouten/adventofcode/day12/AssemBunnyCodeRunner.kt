package com.github.shmvanhouten.adventofcode.day12

import com.github.shmvanhouten.adventofcode.day12.Instruction.*
import com.github.shmvanhouten.adventofcode.day12.Register.A
import com.github.shmvanhouten.adventofcode.day12.Register.B
import com.github.shmvanhouten.adventofcode.day12.Register.C
import com.github.shmvanhouten.adventofcode.day12.Register.D

class AssemBunnyCodeRunner {
    fun runInput(input: String, initialState: BunnyState = BunnyState()): BunnyState {
        val instructions = input.split("\n").map { it.split(' ') }
        var state = initialState

        var index = 0
        while (index < instructions.size){

            val instruction = instructions[index]
            when(instruction[0]){
                CPY.value -> state = runCopyInstruction(instruction, state)
                INC.value -> state = runIncInstruction(instruction[1], state)
                DEC.value -> state = runDecInstruction(instruction[1], state)
                JUMP.value -> index = runJumpInstruction(instruction, index, state)
            }
            index++
        }

        return state
    }

    private fun runJumpInstruction(instruction: List<String>, index: Int, state: BunnyState): Int {
        val registerValue = when(instruction[1]){
            A.value -> state.a
            B.value -> state.b
            C.value -> state.c
            else -> state.d
        }

        return if(registerValue == 0){
            index
        }else {
            val jumpValue = instruction[2].toInt()
            index + jumpValue - 1
        }
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

    private fun runCopyInstruction(instructionParts: List<String>, state: BunnyState): BunnyState {
        val amountToSet = getAmountToSetBy(instructionParts[1], state)
        return when (instructionParts[2]) {
            A.value -> state.setA(amountToSet)
            B.value -> state.setB(amountToSet)
            C.value -> state.setC(amountToSet)
            else -> state.setD(amountToSet)
        }
    }

    private fun getAmountToSetBy(amountVariable: String, state: BunnyState): Int = when(amountVariable) {
        A.value -> state.a
        B.value -> state.b
        C.value -> state.c
        D.value -> state.d
        else -> amountVariable.toInt()
    }
}

enum class Register(val value: String) {
    A("a"),
    B("b"),
    C("c"),
    D("d")
}

enum class Instruction(val value: String){
    CPY("cpy"),
    INC("inc"),
    DEC("dec"),
    JUMP("jnz")
}