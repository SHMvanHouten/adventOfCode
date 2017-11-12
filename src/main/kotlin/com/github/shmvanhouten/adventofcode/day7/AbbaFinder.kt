package com.github.shmvanhouten.adventofcode.day7

class AbbaFinder {
    fun doesStringContainAbba(inputString: String): Boolean {
        return inputString.find { doesItOccurMoreThanOnce(inputString, it) } != null
    }

    private fun doesItOccurMoreThanOnce(inputString: String, char: Char): Boolean {
        return if(inputString.count{ it == char } > 1){
            val split = inputString.split(char)
            split.filterIndexed { index, string -> (index > 0 || index < split.size - 1) && string.length == 2 && string[0] == string[1]}.isNotEmpty()
        }else false
    }
}