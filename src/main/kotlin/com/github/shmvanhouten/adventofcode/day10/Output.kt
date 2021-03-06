package com.github.shmvanhouten.adventofcode.day10

class Output(val outputNumber: Int) : Receiver {

    var chip: Int = -1

    override fun takeChip(value: Int) {
        chip = value
    }
}