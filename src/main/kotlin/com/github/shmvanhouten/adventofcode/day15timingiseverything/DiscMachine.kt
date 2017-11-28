package com.github.shmvanhouten.adventofcode.day15timingiseverything

data class DiscMachine(val discs: Map<Int, Disc> = mapOf()){

    fun addDisc(inputDisc: Disc): DiscMachine {
        return DiscMachine(discs.plus(discs.size + 1 to inputDisc))
    }

    fun addSeconds(amount: Int): DiscMachine {
        val movedDiscs = discs.map { it.key to it.value.move(amount) }.toMap()
        return DiscMachine(movedDiscs)
    }
}
