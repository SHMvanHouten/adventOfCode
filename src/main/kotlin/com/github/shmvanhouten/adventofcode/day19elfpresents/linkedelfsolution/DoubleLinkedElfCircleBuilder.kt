package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

class DoubleLinkedElfCircleBuilder : LinkedElfCircleBuilder {

    override fun buildAndReturnFirst(amountOfElves: Int): LinkedElf {

        val firstElf = LinkedElf(1)

        var previousAddedElf = firstElf


        (2..amountOfElves).forEach {
            val currentElf = LinkedElf(it)

            assignElfNeighbours(previousAddedElf, currentElf)

            previousAddedElf = currentElf
        }

        assignElfNeighbours(previousAddedElf, firstElf)

        return firstElf
    }

    private fun assignElfNeighbours(previousAddedElf: LinkedElf, currentElf: LinkedElf) {
        previousAddedElf.nextElf = currentElf
        currentElf.previousElf = previousAddedElf
    }
}