package com.github.shmvanhouten.adventofcode.day7.util

class IpSplitterUtil {

    fun splitIpIntoSupernetAndHypernetSequences(ip: String): Pair<List<String>, List<String>> {
        val ipParts = ip.split('[', ']')
        val supernetSequences = ipParts.filterIndexed { index, _ -> index % 2 == 0 }
        val hypernetSequences = ipParts.filterIndexed { index, _ -> index % 2 == 1 }
        return Pair(supernetSequences, hypernetSequences)
    }
}