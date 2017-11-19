package com.github.shmvanhouten.adventofcode.day10

import com.github.shmvanhouten.adventofcode.day10.DestinationType.OUTPUT

class InstructionCentral(private val botDispatch: BotDispatch = BotDispatch()) {

    private val VALUE = "value"


    fun findBotThatComparesValues(instructions: String, firstValue: Int, secondValue: Int): Int? {
        carryOutInstructions(instructions)

        return botDispatch.bots.find { it.pickupLog?.lowChip == firstValue && it.pickupLog?.highChip == secondValue }?.pickupLog?.botNumber
    }


    fun findTheChipsInOutputsMultiplied(instructions: String, outputsToMultiply: List<Int>): Int? {
        carryOutInstructions(instructions)

        return botDispatch.outputs.filter { getValuesForOutputsNeeded(it, outputsToMultiply) }.map { it.chip }.reduce{ acc: Int, chip: Int -> acc * chip }
    }

    private fun getValuesForOutputsNeeded(output: Output, outputsToMultiply: List<Int>): Boolean =
            outputsToMultiply.any { it == output.outputNumber }

    private fun carryOutInstructions(instructions: String) {
        val (pickupInstructions, sortingInstructions) = instructions.split("\n")
                .map { it.split(" ") }.partition { it[0] == VALUE }

        botDispatch.bots = buildBots(sortingInstructions)
        botDispatch.outputs = buildOutputs(sortingInstructions)

        botDispatch.givePickupOrdersToBots(pickupInstructions.map { buildPickupOrderFromInstruction(it) })
    }

    private fun buildOutputs(sortingInstructions: List<List<String>>): List<Output> =
            sortingInstructions.mapNotNull { buildOutputFromInstruction(it) }.flatMap { it }

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

    private fun buildPickupOrderFromInstruction(rawInstruction: List<String>): PickupOrder {
        val chip = rawInstruction[1].toInt()
        val destination = Destination(getDestinationType(rawInstruction[4]), rawInstruction[5].toInt())
        return PickupOrder(destination, chip)
    }

    private fun buildBots(sortingInstructions: List<List<String>>): List<SortingBot> =
            sortingInstructions.map { buildBotFromInstruction(it) }

    private fun buildBotFromInstruction(rawInstruction: List<String>): SortingBot {
        val botNumber = rawInstruction[1].toInt()
        val lowChipDestination = Destination(getDestinationType(rawInstruction[5]), rawInstruction[6].toInt())
        val highChipDestination = Destination(getDestinationType(rawInstruction[10]), rawInstruction[11].toInt())
        val instruction = Instruction(lowChipDestination, highChipDestination)
        return SortingBot(instruction, botDispatch, botNumber)
    }

}
