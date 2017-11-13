package com.github.shmvanhouten.adventofcode.day7

class AbaFinder {
    fun getAllPotentialBabsFromSequence(sequence: String): List<String> {
        return sequence.flatMap { getBabsFromAbasStartingWithChar(sequence, it) }.distinct()
    }

    private fun getBabsFromAbasStartingWithChar(sequence: String, char: Char): List<String> {
        val potentialAbas = sequence.split(char)
                .filterIndexed { index, _ -> (index > 0 && index < sequence.split(char).size - 1) }
                .filter { it.length == 1 && it[0] != char }
        return if ( !potentialAbas.isEmpty()) {
            potentialAbas.map { it + char + it }
        } else emptyList()
    }
}