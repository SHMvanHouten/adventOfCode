package com.github.shmvanhouten.adventofcode.day19elfpresents

class ElfPartySimulatorAcrossEdition {
    fun getLuckyElf(amountOfElves: Int): Int {
        val elfCircle: MutableList<Elf> = assembleElfParty(amountOfElves)
        var currentElfIndex = 0
        while (elfCircle.size != 1){

            val size = elfCircle.size
            val indexOFElfToRemove = (currentElfIndex + (size /2)) % size
//            println("At size $size elf ${elfCircle[currentElfIndex]} removed ${elfCircle[indexOFElfToRemove]}")
            elfCircle.removeAt(indexOFElfToRemove)

            currentElfIndex = getIndexOfNextElf(currentElfIndex, elfCircle, indexOFElfToRemove)
        }
        return elfCircle[0].number
    }

    private fun getIndexOfNextElf(currentElfIndex: Int, elfCircle: MutableList<Elf>, indexOFElfToRemove: Int): Int {
        val sizeAfterRemoval = elfCircle.size
        return when (currentElfIndex) {
            sizeAfterRemoval -> 0
            sizeAfterRemoval - 1 -> currentElfIndex
            else -> if(currentElfIndex > indexOFElfToRemove) currentElfIndex else currentElfIndex + 1
        }
    }

    private fun assembleElfParty(amountOfElves: Int): MutableList<Elf> {
        return (1..(amountOfElves)).map { Elf(it) }.toMutableList()
    }


}