package com.github.shmvanhouten.adventofcode.day25clocksignal

import com.github.shmvanhouten.adventofcode.day12.BunnyState
import com.github.shmvanhouten.adventofcode.day12.RawInstructionConverter
import com.github.shmvanhouten.adventofcode.day12.instruction.OutInstruction

class AssemBunnyClockSignalFinder (private val rawInstructionConverter: RawInstructionConverter = RawInstructionConverter()) {

    private val AMOUNT_OF_CYCLES_TO_CHECK = 10000

    fun findValueOfARequiredForSignal(input: String, initialState: BunnyState = BunnyState()): Int {

        var aRegisterStartingValue = 0

        var amountOfTimesRunWithCurrentStartingBunnyState = 0

        var previousOutputValue = 1

        val instructionList = rawInstructionConverter.convertRawInstructionToInstructionList(input)

        var state = initialState

        var index = 0

        while (true){
            val instruction = instructionList[index]
            val (newIndex, newBunnyState) = instruction.executeInstruction(index, state)

            if(instruction is OutInstruction){
                val newOutputValue = state.get(instruction.registerToOutput)
                if(newOutputValue == previousOutputValue){
                    aRegisterStartingValue++
                    state = BunnyState(a = aRegisterStartingValue)
                    amountOfTimesRunWithCurrentStartingBunnyState = 0
                    previousOutputValue = 1
                    index = 0
                } else{
                    previousOutputValue = newOutputValue
                    amountOfTimesRunWithCurrentStartingBunnyState++
                    if(amountOfTimesRunWithCurrentStartingBunnyState == AMOUNT_OF_CYCLES_TO_CHECK){
                        return aRegisterStartingValue
                    }
                    index++
                }
            }else {
                state = newBunnyState
                index = newIndex
            }
        }
    }

}

fun main(args: Array<String>) {
    val codeRunner = AssemBunnyClockSignalFinder()
    val day25ChallengeInput = """cpy a d
cpy 14 c
cpy 182 b
inc d
dec b
jnz b -2
dec c
jnz c -5
cpy d a
jnz 0 0
cpy a b
cpy 0 a
cpy 2 c
jnz b 2
jnz 1 6
dec b
dec c
jnz c -4
inc a
jnz 1 -7
cpy 2 b
jnz c 2
jnz 1 4
dec b
dec c
jnz 1 -4
jnz 0 0
out b
jnz a -19
jnz 1 -21"""
    val a = codeRunner.findValueOfARequiredForSignal(day25ChallengeInput, BunnyState())
    println(a)
}