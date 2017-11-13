package com.github.shmvanhouten.adventofcode.day7

import com.github.shmvanhouten.adventofcode.day7.util.IpSplitterUtil

class TLSSupportCheckerForIp(private val abbaFinder: AbbaFinder = AbbaFinder(), private val ipSplitterUtil: IpSplitterUtil = IpSplitterUtil()) {

    fun countIpsThatSupportTLS(ips: String): Int {
        return ips.split("\n").count { doesIpSupportTLS(it.trim()) }
    }

    fun doesIpSupportTLS(ip: String): Boolean {
        val (supernetSequences, hypernetSequences) = ipSplitterUtil.splitIpIntoSupernetAndHypernetSequences(ip)

        return (!hypernetSequences.any { abbaFinder.doesStringContainAbba(it) }
                && supernetSequences.any { abbaFinder.doesStringContainAbba(it) })
    }
}

