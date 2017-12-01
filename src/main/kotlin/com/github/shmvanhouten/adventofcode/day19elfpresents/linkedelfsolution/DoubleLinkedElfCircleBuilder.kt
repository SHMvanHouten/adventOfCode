package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

class DoubleLinkedElfCircleBuilder : LinkedElfCircleBuilder {

    override fun buildAndReturnFirst(amountOfElves: Int): LinkedElf {

        val firstElf = LinkedElf(1)

        var previousAddedElf = firstElf

        for(index in 2..amountOfElves){
            val currentElf = LinkedElf(index)
            previousAddedElf.nextElf = currentElf
            currentElf.previousElf = previousAddedElf

            previousAddedElf = currentElf
        }

        previousAddedElf.nextElf = firstElf
        firstElf.previousElf = previousAddedElf

        return firstElf
    }
}