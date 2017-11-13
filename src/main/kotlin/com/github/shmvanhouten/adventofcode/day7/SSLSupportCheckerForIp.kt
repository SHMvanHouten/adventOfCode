package com.github.shmvanhouten.adventofcode.day7

class SSLSupportCheckerForIp (private val abaFinder: AbaFinder = AbaFinder(), private val abaToBabMatcher: AbaToBabMatcher = AbaToBabMatcher()){

    fun countIpsthatSupportSSL(ips: String): Int {
        return ips.split("\n").count { doesIpSupportSSL(it.trim()) }
    }

    fun doesIpSupportSSL(ip: String): Boolean {
        val ipParts = ip.split('[', ']')
        val supernetSequences = ipParts.filterIndexed { index, _ -> index % 2 == 0 }
        val hypernetSequences = ipParts.filterIndexed { index, _ -> index % 2 == 1 }

        val abaList = supernetSequences.flatMap { abaFinder.getAllAbasFromString(it) }
        return hypernetSequences.any { abaToBabMatcher.findBabMatchesInSequenceForAbas(it, abaList) }
    }

}