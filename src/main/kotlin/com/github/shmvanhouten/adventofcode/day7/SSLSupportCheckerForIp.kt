package com.github.shmvanhouten.adventofcode.day7

import com.github.shmvanhouten.adventofcode.day7.util.IpSplitterUtil

class SSLSupportCheckerForIp(private val abaFinder: AbaFinder = AbaFinder(),
                             private val abaToBabMatcher: AbaToBabMatcher = AbaToBabMatcher(),
                             private val ipSplitterUtil: IpSplitterUtil = IpSplitterUtil()) {

    fun countIpsThatSupportSSL(ips: String): Int {
        return ips.split("\n").count { doesIpSupportSSL(it.trim()) }
    }

    fun doesIpSupportSSL(ip: String): Boolean {
        val (supernetSequences, hypernetSequences) = ipSplitterUtil.splitIpIntoSupernetAndHypernetSequences(ip)

        val babList = supernetSequences.flatMap { abaFinder.getAllPotentialBabsFromSequence(it) }
        return hypernetSequences.any { abaToBabMatcher.findBabMatchesInSequence(it, babList) }
    }

}