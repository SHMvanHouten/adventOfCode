package com.github.shmvanhouten.adventofcode.day23assembunny2point0

import com.github.shmvanhouten.adventofcode.day12.AssembunnyCodeRunner
import com.github.shmvanhouten.adventofcode.day12.BunnyState
import com.github.shmvanhouten.adventofcode.day12.RawInstructionConverter
import com.github.shmvanhouten.adventofcode.day12.instruction.JumpDependentOnRegisterInstruction
import com.github.shmvanhouten.adventofcode.day23assembunny2point0.instruction.ToggleInstruction

class AdvancedAssembunnyCodeRunner(private val rawInstructionConverter: RawInstructionConverter = RawInstructionConverter()) : AssembunnyCodeRunner {

    override fun runInput(input: String, initialState: BunnyState): BunnyState {
        val instructionList = rawInstructionConverter.convertRawInstructionToInstructionList(input).toMutableList()

        var state = initialState

        var index = 0

        val instructionsSize = instructionList.size
        while (index < instructionsSize) {
            val instruction = instructionList[index]

            if (instruction is ToggleInstruction) {
                val indexOfInstructionToToggle = instruction.getIndexOfInstructionToToggle(state, index)
                if (indexOfInstructionToToggle < instructionsSize) {
                    val changedInstruction = instruction.changeInstruction(instructionList[indexOfInstructionToToggle])
                    instructionList[indexOfInstructionToToggle] = changedInstruction
                }
            }

            val (newIndex, newBunnyState) = instruction.executeInstruction(index, state)

            if(instruction is JumpDependentOnRegisterInstruction){

            }

            state = newBunnyState
            index = newIndex
        }

        return state
    }
}