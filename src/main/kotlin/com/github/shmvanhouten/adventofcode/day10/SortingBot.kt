package com.github.shmvanhouten.adventofcode.day10

class SortingBot(private val instruction: Instruction, val instructionCentral: InstructionCentral, val botNumber: Int): Receiver {

    private var firstChip: Int = -1
    var pickupLog: PickupLog? = null

    override fun takeChip(value: Int){
        if (firstChip == -1) {
            firstChip = value
        }
        else performTask(value, firstChip)
    }

    private fun performTask(secondChip: Int, firstChip: Int) {
        val sortedChips = sortChips(firstChip, secondChip)

        val lowChipDestination: Receiver = instructionCentral.retrieveReceiver(instruction.lowChipDestination)
        lowChipDestination.takeChip(sortedChips.first)

        val highChipDestination: Receiver = instructionCentral.retrieveReceiver(instruction.highChipDestination)
        highChipDestination.takeChip(sortedChips.second)

        pickupLog = PickupLog(botNumber, sortedChips.first, sortedChips.second)
    }


    private fun sortChips(firstChip: Int, secondChip: Int): Pair<Int, Int> {
        return if(firstChip > secondChip) Pair(secondChip, firstChip)
        else Pair(firstChip, secondChip)
    }
}