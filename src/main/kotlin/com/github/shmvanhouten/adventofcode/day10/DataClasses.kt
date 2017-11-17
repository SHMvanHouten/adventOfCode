package com.github.shmvanhouten.adventofcode.day10

data class Instruction(val lowChipDestination: Destination, val highChipDestination: Destination)

data class Task(val destination: Destination, val chip: Int)

data class Destination(val destinationType: DestinationType, val number: Int)

enum class DestinationType {
    BOT,
    OUTPUT;

    fun getDestination(value: String): DestinationType? = DestinationType.values().find { it.toString() == value.toUpperCase() }
}