package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

class ElfCircleBuilder {
    fun buildAndReturnFirst(amountOfElves: Int): LinkedElf {
        val firstElf = LinkedElf(1)

        var previousAddedElf = firstElf

        for(index in 2..amountOfElves){
            val currentElf = LinkedElf(index)
            previousAddedElf.nextElf = currentElf

            previousAddedElf = currentElf
        }

        previousAddedElf.nextElf = firstElf

        return firstElf
    }
}