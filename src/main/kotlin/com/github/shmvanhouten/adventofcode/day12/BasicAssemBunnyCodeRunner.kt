package com.github.shmvanhouten.adventofcode.day12

import com.github.shmvanhouten.adventofcode.day12.instruction.OutInstruction

class BasicAssemBunnyCodeRunner(private val rawInstructionConverter: RawInstructionConverter = RawInstructionConverter()): AssembunnyCodeRunner {

    override fun runInput(input: String, initialState: BunnyState): BunnyState {

        var aRegisterStartingValue = 0

        var amountOfTimesRunWithCurrentStartingBunnyState = 0

        var previousOut = 1


        val instructionList = rawInstructionConverter.convertRawInstructionToInstructionList(input)

        var state = initialState

        var index = 0

        while (index < instructionList.size){
            val instruction = instructionList[index]
            val (newIndex, newBunnyState) = instruction.executeInstruction(index, state)

            if(instruction is OutInstruction){
                val newOut = state.get(instruction.registerToOutput)
                if(newOut == previousOut){
                    aRegisterStartingValue++
                    state = BunnyState(a = aRegisterStartingValue)
                    amountOfTimesRunWithCurrentStartingBunnyState = 0
                    previousOut = 1
                    index = 0
                } else{
                    previousOut = newOut
                    amountOfTimesRunWithCurrentStartingBunnyState++
                    if(amountOfTimesRunWithCurrentStartingBunnyState == 10000){
                        return BunnyState(a = aRegisterStartingValue)
                    }
                    index++
                }
            }else {
                state = newBunnyState
                index = newIndex
            }
        }

        return state
    }


}

fun main(args: Array<String>) {
    val codeRunner = BasicAssemBunnyCodeRunner()
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
    val bunnyState = codeRunner.runInput(day25ChallengeInput, BunnyState(a = 182))
    println(bunnyState.a)
}
