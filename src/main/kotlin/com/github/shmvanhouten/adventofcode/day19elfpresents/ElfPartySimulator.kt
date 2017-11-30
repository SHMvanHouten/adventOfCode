package com.github.shmvanhouten.adventofcode.day19elfpresents

class ElfPartySimulator {

    fun getLuckyElf(amountOfElves: Int): Int {
        val elfCircle = buildElfCircle(amountOfElves)
        var currentElfNumber = 1
        while (elfCircle.size != 1) {
            val elfToTakeFrom = elfCircle.getValue(currentElfNumber)
            val nextElfNumber = elfCircle.getValue(elfToTakeFrom)
            elfCircle.remove(elfToTakeFrom)
            elfCircle.put(currentElfNumber, nextElfNumber)
            currentElfNumber = nextElfNumber
        }
        return currentElfNumber
    }

    private fun buildElfCircle(amountOfElves: Int): MutableMap<Int, Int> {
        val elves = 1.until(amountOfElves).associateBy({ it }, { it + 1 })
        return elves.plus(amountOfElves to 1).toMutableMap()
    }
}