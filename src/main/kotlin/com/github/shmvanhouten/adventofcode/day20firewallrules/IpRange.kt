package com.github.shmvanhouten.adventofcode.day20firewallrules

data class IpRange(val min: Long, val max: Long): Comparable<IpRange> {

    override fun compareTo(other: IpRange): Int {
        return this.min.compareTo(other.min)
    }

}