package com.github.shmvanhouten.adventofcode.day10

import com.github.shmvanhouten.adventofcode.day10.DestinationType.BOT

class InstructionCentral {

    private val VALUE = "value"
    var bots: List<SortingBot> = emptyList()

    fun findBotThatComparesValues(instructions: String, firstValue: Int, secondValue: Int): Int? {
        val (pickupInstructions, sortingInstructions) = instructions.split("\n")
                .map { it.split(" ") }.partition { it[0] == VALUE }

        carryOutInstructions(pickupInstructions, sortingInstructions)

        return bots.find { it.pickupLog?.lowChip == firstValue && it.pickupLog?.highChip == secondValue }?.pickupLog?.botNumber
    }

    fun retrieveReceiver(destination: Destination): Receiver = when(destination.destinationType){
        BOT -> bots.find { it.botNumber == destination.number }!!
        else -> Output()
    }

    private fun carryOutInstructions(pickupInstructions: List<List<String>>, sortingInstructions: List<List<String>>) {
        bots = buildBots(sortingInstructions)
        return pickupInstructions.forEach { carryOutPickup(buildTask(it)) }
    }

    private fun buildTask(rawInstruction: List<String>): Task {
        val chip = rawInstruction[1].toInt()
        val destination = Destination(getDestinationType(rawInstruction[4]), rawInstruction[5].toInt())
        return Task(destination, chip)
    }

    private fun carryOutPickup(task: Task) {
        bots.find { it.botNumber == task.destination.number }?.takeChip(task.chip)
    }

    private fun buildBots(sortingInstructions: List<List<String>>): List<SortingBot> =
            sortingInstructions.map { buildBotFromInstruction(it) }

    private fun buildBotFromInstruction(rawInstruction: List<String>): SortingBot {
        val botNumber = rawInstruction[1].toInt()
        val lowChipDestination = Destination(getDestinationType(rawInstruction[5]), rawInstruction[6].toInt())
        val highChipDestination = Destination(getDestinationType(rawInstruction[10]), rawInstruction[11].toInt())
        val instruction = Instruction(lowChipDestination, highChipDestination)
        return SortingBot(instruction, this, botNumber)
    }



}