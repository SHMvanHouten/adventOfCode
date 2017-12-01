package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

class LinkedElfPartySimulator(private val elfCircleBuilder: LinkedElfCircleBuilder): ElfPartySimulator {

    override fun getLuckyElf(amountOfElves: Int): LinkedElf {

        var currentElf = elfCircleBuilder.buildAndReturnFirst(amountOfElves)

        while (currentElf.number != currentElf.nextElf.number){
            val elfToStealFrom = currentElf.nextElf
            val newNextElf = elfToStealFrom.nextElf
            currentElf.changeLeftNeighbour(newNextElf)

            currentElf = newNextElf
        }


        return currentElf
    }


}