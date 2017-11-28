package com.github.shmvanhouten.adventofcode.day16dragonchecksum

class Dragonifier {
    fun dragonify(startingInput: String): String {
        val dragonBuilder = StringBuilder(startingInput)
        dragonBuilder.append('0')
        startingInput.reversed()
                .map { if (it == '0') '1' else '0' }
                .forEach { dragonBuilder.append(it)  }
        return dragonBuilder.toString()
    }
}