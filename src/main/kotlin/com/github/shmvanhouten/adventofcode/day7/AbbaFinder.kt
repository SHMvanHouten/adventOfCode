package com.github.shmvanhouten.adventofcode.day7

class AbbaFinder {
    fun doesStringContainAbba(inputString: String): Boolean {
        return inputString.any { isCharPartOfAnAbba(inputString, it) }
    }

    private fun isCharPartOfAnAbba(inputString: String, char: Char): Boolean {
        val splitInputString = inputString.split(char)
        return splitInputString.filterIndexed { index, _ -> (index > 0 && index < splitInputString.size - 1) }.any { it.length == 2 && it[0] == it[1] && it[0] != char }
    }
}

