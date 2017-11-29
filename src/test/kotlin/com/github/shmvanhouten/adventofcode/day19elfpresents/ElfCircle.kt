package com.github.shmvanhouten.adventofcode.day19elfpresents

data class ElfCircle (private var elves: Map<Int, Elf>) {

    fun first(): Elf {
        return elves.getValue(1)
    }

    fun haveElfTakeFromNext(currentElfNumber: Int) {
        val currentElf = elves.getValue(currentElfNumber)
        val nextElfNumber = currentElf.elfNumberItTakesFrom
        val nextElf = elves.getValue(nextElfNumber)
//        val newCurrentElfAmountOfPresents = currentElf.amountOfPresents + nextElf.amountOfPresents
        val newCurrentElf = Elf(currentElfNumber, nextElf.elfNumberItTakesFrom)
        elves = elves.minus(currentElfNumber).minus(nextElfNumber).plus(currentElfNumber to newCurrentElf)
        println(elves.size)
    }

    fun getNext(currentElfNumber: Int): Int {
        val currentElf = elves.getValue(currentElfNumber)
        return currentElf.elfNumberItTakesFrom
    }

    fun size(): Int = elves.size


}