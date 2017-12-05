package com.github.shmvanhouten.adventofcode.day12

class AssemBunnyCodeRunner(private val rawInstructionConverter: RawInstructionConverter = RawInstructionConverter()) {
    fun runInput(input: String, initialState: BunnyState = BunnyState()): BunnyState {

        val instructionList = rawInstructionConverter.convertRawInstructionToInstructionList(input)

        var state = initialState

        var index = 0

        while (index < instructionList.size){
            val (newIndex, newBunnyState) = instructionList[index].executeInstruction(index, state)
            state = newBunnyState
            index = newIndex
        }

        return state
    }


}

