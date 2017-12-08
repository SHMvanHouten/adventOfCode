package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

/* Once the first elf to dismiss (unlucky elf) is found, the next elf to dismiss will be either one step or two
  * steps away from the last unlucky elf, which means we only need to do the expensive search for an elf
*/

class ElfPartySimulatorAcrossImpl(private val elfCircleBuilder: DoubleLinkedElfCircleBuilder) : ElfPartySimulator {
    override fun getLuckyElf(amountOfElves: Int): LinkedElf {

        val firstElf = elfCircleBuilder.buildAndReturnFirst(amountOfElves)

        var amountOfElvesLeft = amountOfElves

        var nextElfToDismiss = getElfXPositionsAway(firstElf, amountOfElvesLeft / 2)

        while (amountOfElvesLeft != 1) {

            dismissElf(nextElfToDismiss)

            nextElfToDismiss = getNextElfToDismiss(nextElfToDismiss, amountOfElvesLeft)

            amountOfElvesLeft--
        }


        return nextElfToDismiss.nextElf
    }

    private fun getNextElfToDismiss(dismissedElf: LinkedElf, amountOfElves: Int): LinkedElf {
        return getElfXPositionsAway(dismissedElf, amountOfElves % 2 + 1)
    }

    private fun dismissElf(unluckyElf: LinkedElf) {
        unluckyElf.previousElf.changeLeftNeighbour(unluckyElf.nextElf)
        unluckyElf.nextElf.changeRightNeighbour(unluckyElf.previousElf)
    }

    private tailrec fun getElfXPositionsAway(startingElf: LinkedElf, amountOfElvesRemoved: Int): LinkedElf {
        if (amountOfElvesRemoved == 0) return startingElf
        return getElfXPositionsAway(startingElf.nextElf, amountOfElvesRemoved - 1)
    }
}

fun main(args: Array<String>) {
    val doubleLinkedElfCircleBuilder = DoubleLinkedElfCircleBuilder()
    val elfPartySimulatorAcrossImpl = ElfPartySimulatorAcrossImpl(doubleLinkedElfCircleBuilder)
    val luckyElf = elfPartySimulatorAcrossImpl.getLuckyElf(3018458)
    println(luckyElf)
}
