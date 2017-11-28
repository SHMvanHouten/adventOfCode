package com.github.shmvanhouten.adventofcode.day16dragonchecksum

class CheckSumFromInputGetter {

    val dragonBuilder = DragonBuilder()
    val checkSumBuilder = CheckSumBuilder()

    fun getCheckSum(input: String, maxDiskLength: Int): String {
        val dragonFile = dragonBuilder.build(input, maxDiskLength)
        return checkSumBuilder.buildCheckSum(dragonFile)
    }

}