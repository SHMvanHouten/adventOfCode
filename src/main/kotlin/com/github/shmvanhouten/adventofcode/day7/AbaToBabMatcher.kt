package com.github.shmvanhouten.adventofcode.day7

class AbaToBabMatcher {
    fun findBabMatchesInSequenceForAbas(hypernetSequence: String, abaList: List<String>): Boolean {
        val potentialBabs = abaList.map { "${it[1]}${it[0]}${it[1]}" }
        return potentialBabs.any { hypernetSequence.contains(it) }
    }
}