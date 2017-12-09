package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

class ElfCircleBuilder : LinkedElfCircleBuilder {

    override fun buildAndReturnFirst(amountOfElves: Int): LinkedElf {
        val firstElf = LinkedElf(1)

        var previousAddedElf = firstElf

        (2..amountOfElves).forEach { elfNumber ->
            val currentElf = LinkedElf(elfNumber)
            previousAddedElf.nextElf = currentElf

            previousAddedElf = currentElf
        }

        previousAddedElf.nextElf = firstElf

        return firstElf
    }
}