package com.github.shmvanhouten.adventofcode.day20firewallrules

class UnblockedIpFinder {

    fun getLowestUnblockedIp(blockedIpsRawInput: String): Long {
        val blockedIps = blockedIpsRawInput.split("\n").map { buildIpRange(it) }.toSortedSet()

        var firstUnblockedNumber: Long = 0
        for (blockedIp in blockedIps) {
            if (blockedIp.min > firstUnblockedNumber) {
                return firstUnblockedNumber
            }
            if (blockedIp.max + 1 > firstUnblockedNumber) {
                firstUnblockedNumber = blockedIp.max + 1
            }
        }
        return firstUnblockedNumber
    }

    fun getAllUnblockedIps(blockedIpsRawInput: String, maxIp: Long): List<Long> {
        val blockedIps = blockedIpsRawInput.split("\n").map { buildIpRange(it) }.toSortedSet()
        blockedIps += IpRange(maxIp, maxIp)

        var unblockedIps = listOf<Long>()

        var firstUnblockedNumber: Long = 0
        for (blockedIp in blockedIps) {
            val minimalBlockedIpByIpRange = blockedIp.min
            if (minimalBlockedIpByIpRange > firstUnblockedNumber) {
                for (ipNumber in firstUnblockedNumber.until(minimalBlockedIpByIpRange)){
                    unblockedIps += ipNumber
                }
            }
            if (blockedIp.max + 1 > firstUnblockedNumber) {
                firstUnblockedNumber = blockedIp.max + 1
            }
        }

        return unblockedIps
    }

    private fun buildIpRange(rawRange: String): IpRange {
        val split = rawRange.split("-")
        return IpRange(split[0].toLong(), split[1].toLong())
    }

}