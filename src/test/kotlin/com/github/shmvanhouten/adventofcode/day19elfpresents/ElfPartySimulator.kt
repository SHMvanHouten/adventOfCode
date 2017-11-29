package com.github.shmvanhouten.adventofcode.day19elfpresents

class ElfPartySimulator {
    fun getLuckyElf(amountOfElves: Int): Int {
        val elfCircle = buildElfCircleAndGetFirstElf(amountOfElves)
        var currentElfNumber = 1
        while (elfCircle.size() != 1) {
            elfCircle.haveElfTakeFromNext(currentElfNumber)
            currentElfNumber = elfCircle.getNext(currentElfNumber)
        }
        return currentElfNumber
    }

    private fun buildElfCircleAndGetFirstElf(amountOfElves: Int): ElfCircle {
        val elves = 1.until(amountOfElves).associateBy({ it }, { Elf(it, it + 1) })
        return ElfCircle(elves.plus(amountOfElves to Elf(amountOfElves, 1)))
    }
}