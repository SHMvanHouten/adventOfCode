package com.github.shmvanhouten.adventofcode.day10

import com.github.shmvanhouten.adventofcode.day10.DestinationType.BOT

data class Instruction(val lowChipDestination: Destination, val highChipDestination: Destination)

data class PickupOrder(val destination: Destination, val chip: Int)

data class Destination(val destinationType: DestinationType, val number: Int)

data class PickupLog(val botNumber: Int, val lowChip: Int, val highChip :Int)

enum class DestinationType {
    BOT,
    OUTPUT;
}

fun getDestinationType(value: String): DestinationType = DestinationType.values().find { it.toString() == value.toUpperCase() } ?: BOT

