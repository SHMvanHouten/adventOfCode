package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

class ElfPartySimulatorAcrossImpl(private val elfCircleBuilder: DoubleLinkedElfCircleBuilder) : ElfPartySimulator {
    override fun getLuckyElf(amountOfElves: Int): LinkedElf {

        var currentElf = elfCircleBuilder.buildAndReturnFirst(amountOfElves)

        var amountOfElvesLeft = amountOfElves

        while (amountOfElvesLeft != 1) {
//            println("there are $amountOfElvesLeft elves left")
//            println("it's elf $currentElf's turn")

            findAndDismissElfAcross(currentElf, amountOfElvesLeft)

            val neighbour = currentElf.nextElf
            currentElf = neighbour
            amountOfElvesLeft--
        }


        return currentElf
    }

    private fun findAndDismissElfAcross(currentElf: LinkedElf, amountOfElves: Int) {
        val unluckyElf = getElfXPositionsAway(currentElf, (amountOfElves / 2))
//        println("unlucky elf $unluckyElf was removed")
        unluckyElf.previousElf.changeLeftNeighbour(unluckyElf.nextElf)
        unluckyElf.nextElf.changeRightNeighbour(unluckyElf.previousElf)
    }

    private tailrec fun getElfXPositionsAway(startingElf: LinkedElf, amountOfElvesRemoved: Int): LinkedElf {
//        var amountOfElvesStillRemoved = amountOfElvesRemoved
//        var currentElf = startingElf
//        while (amountOfElvesStillRemoved != 0){
//            currentElf = currentElf.nextElf
//            amountOfElvesStillRemoved--
//        }
//        return currentElf

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
