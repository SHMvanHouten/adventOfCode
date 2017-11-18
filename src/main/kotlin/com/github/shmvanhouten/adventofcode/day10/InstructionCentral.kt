package com.github.shmvanhouten.adventofcode.day10

import com.github.shmvanhouten.adventofcode.day10.DestinationType.BOT
import com.github.shmvanhouten.adventofcode.day10.DestinationType.OUTPUT

class InstructionCentral {

    private val VALUE = "value"
    var bots: List<SortingBot> = emptyList()
    var outputs: List<Output> = emptyList()

    fun findBotThatComparesValues(instructions: String, firstValue: Int, secondValue: Int): Int? {
        carryOutInstructions(instructions)

        return bots.find { it.pickupLog?.lowChip == firstValue && it.pickupLog?.highChip == secondValue }?.pickupLog?.botNumber
    }


    fun retrieveReceiver(destination: Destination): Receiver = when (destination.destinationType) {
        BOT -> bots.find { it.botNumber == destination.number }!!
        else -> outputs.find { it.outputNumber == destination.number }!!
    }


    fun findTheChipsInOutputsMultiplied(instructions: String, outputsToMultiply: List<Int>): Int? {
        carryOutInstructions(instructions)
        return outputs.filter { getValuesForOutputsNeeded(it, outputsToMultiply) }.map { it.chip!! }.reduce{ acc: Int, chip: Int -> acc * chip }
    }

    private fun getValuesForOutputsNeeded(output: Output, outputsToMultiply: List<Int>): Boolean {
        return outputsToMultiply.any { it == output.outputNumber }
    }

    private fun carryOutInstructions(instructions: String) {
        val (pickupInstructions, sortingInstructions) = instructions.split("\n")
                .map { it.split(" ") }.partition { it[0] == VALUE }

        carryOutInstructions(pickupInstructions, sortingInstructions)
    }

    private fun carryOutInstructions(pickupInstructions: List<List<String>>, sortingInstructions: List<List<String>>) {
        bots = buildBots(sortingInstructions)
        outputs = buildOutputs(sortingInstructions)
        return pickupInstructions.forEach { carryOutPickup(buildTask(it)) }
    }

    private fun buildOutputs(sortingInstructions: List<List<String>>): List<Output> {
        return sortingInstructions.mapNotNull { buildOutputFromInstruction(it) }.flatMap { it }
    }

    private fun buildOutputFromInstruction(rawInstruction: List<String>): List<Output>? {
        val listOfOutputs = mutableListOf<Output>()
        if (getDestinationType(rawInstruction[5]) == OUTPUT) {
            listOfOutputs.add(Output(rawInstruction[6].toInt()))
        }
        if (getDestinationType(rawInstruction[10]) == OUTPUT) {
            listOfOutputs.add(Output(rawInstruction[11].toInt()))
        }
        return listOfOutputs
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
