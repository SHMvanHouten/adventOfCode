package com.github.shmvanhouten.adventofcode.day7

class AbbaFinder {
    fun doesStringContainAbba(inputString: String): Boolean {
        return inputString.find { doesItOccurMoreThanOnce(inputString, it) } != null
    }

    private fun doesItOccurMoreThanOnce(inputString: String, char: Char): Boolean {
        val split = inputString.split(char)
        val startAndEndRemoved = split.filterIndexed { index, _ -> (index > 0 && index < split.size - 1) }
        return startAndEndRemoved.any { it.length == 2 && it[0] == it[1] && it[0] != char }
    }
}

