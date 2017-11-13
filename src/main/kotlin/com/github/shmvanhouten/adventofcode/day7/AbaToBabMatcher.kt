package com.github.shmvanhouten.adventofcode.day7

class AbaToBabMatcher {
    fun findBabMatchesInSequence(hypernetSequence: String, babList: List<String>): Boolean {
        return babList.any { hypernetSequence.contains(it) }
    }
}