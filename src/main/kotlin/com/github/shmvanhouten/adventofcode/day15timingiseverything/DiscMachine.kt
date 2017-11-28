package com.github.shmvanhouten.adventofcode.day15timingiseverything

data class DiscMachine(val discs: Map<Int, Disc> = mapOf()){

    fun addDisc(inputDisc: Disc): DiscMachine {
        return DiscMachine(discs.plus(discs.size + 1 to inputDisc))
    }

    fun addSecond(): DiscMachine {
        val movedDiscs = discs.map { it.key to it.value.move() }.toMap()
        return DiscMachine(movedDiscs)
    }

    fun addSeconds(amountOfMoves: Int): DiscMachine {
        val movedDiscs = discs.map { it.key to it.value.move(amountOfMoves) }.toMap()
        return DiscMachine(movedDiscs)
    }
}
