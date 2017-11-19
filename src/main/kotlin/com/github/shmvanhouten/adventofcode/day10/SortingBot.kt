package com.github.shmvanhouten.adventofcode.day10

class SortingBot(private val instruction: Instruction, private val botDispatch: BotDispatch, val botNumber: Int): Receiver {

    private var firstChip: Int = -1
    var pickupLog: PickupLog? = null

    override fun takeChip(value: Int){
        if (firstChip == -1) {
            firstChip = value
        }
        else performTask(value, firstChip)
    }

    private fun performTask(secondChip: Int, firstChip: Int) {
        val (lowChip, highChip) = sortChips(firstChip, secondChip)

        botDispatch.retrieveReceiver(instruction.lowChipDestination)?.takeChip(lowChip)

        botDispatch.retrieveReceiver(instruction.highChipDestination)?.takeChip(highChip)

        pickupLog = PickupLog(botNumber, lowChip, highChip)
    }


    private fun sortChips(firstChip: Int, secondChip: Int): Pair<Int, Int> {
        return if(firstChip > secondChip) Pair(secondChip, firstChip)
        else Pair(firstChip, secondChip)
    }
}