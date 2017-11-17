package com.github.shmvanhouten.adventofcode.day10

class SortingBot(private val instruction: Instruction) {

    private var firstChip: Int = -1

    fun takeChip(value: Int): Pair<Task, Task>?{
        return if (firstChip == -1) {
            firstChip = value
            null
        }
        else performTask(value, firstChip)
    }

    private fun performTask(secondChip: Int, firstChip: Int): Pair<Task, Task> {
        val sortedChips = sortChips(firstChip, secondChip)
        return Pair(Task(instruction.lowChipDestination, sortedChips.first),
                Task(instruction.highChipDestination, sortedChips.second))
    }

    private fun sortChips(firstChip: Int, secondChip: Int): Pair<Int, Int> {
        return if(firstChip > secondChip) Pair(secondChip, firstChip)
        else Pair(firstChip, secondChip)
    }
}