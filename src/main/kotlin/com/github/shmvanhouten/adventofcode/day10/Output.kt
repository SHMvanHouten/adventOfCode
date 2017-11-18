package com.github.shmvanhouten.adventofcode.day10

class Output(val outputNumber: Int) : Receiver {

    var chip: Int? = null

    override fun takeChip(value: Int) {
        chip = value
    }
}