package com.github.shmvanhouten.adventofcode.day16dragonchecksum

class DragonBuilder {

    private val dragonifier = Dragonifier()

    fun build(input: String, characterLimit: Int): String {
       var dragonifiedResult = input

        while (dragonifiedResult.length < characterLimit){
            dragonifiedResult = dragonifier.dragonify(dragonifiedResult)
        }

        return dragonifiedResult.substring(0, characterLimit)
    }
}