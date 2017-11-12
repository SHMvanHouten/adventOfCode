package com.github.shmvanhouten.adventofcode.day7

class TLSSupportCheckerForIp(private val abbaFinder: AbbaFinder = AbbaFinder()) {

    fun countIpsthatSupportTLS(ips: String): Int {
        return ips.split("\n").count { doesIpSupportTLS(it.trim()) }
    }

    fun doesIpSupportTLS(ip: String): Boolean {
        val ipParts = ip.split('[', ']')
        val normalSequences = ipParts.filterIndexed { index, _ -> index % 2 == 0 }
        val hypernetSequences = ipParts.filterIndexed { index, _ -> index % 2 == 1 }

        return (!hypernetSequences.any { abbaFinder.doesStringContainAbba(it) }
                && normalSequences.any { abbaFinder.doesStringContainAbba(it) })
    }
}

