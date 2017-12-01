package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

data class LinkedElf(val number: Int): Comparable<LinkedElf> {
    var nextElf: LinkedElf = this
    var previousElf: LinkedElf = this

    fun changeLeftNeighbour(nextElf: LinkedElf) {
        this.nextElf = nextElf
    }

    fun changeRightNeighbour(previousElf: LinkedElf) {
        this.previousElf = previousElf
    }

    override operator fun compareTo(nextElf: LinkedElf): Int {
        return this.number.compareTo(nextElf.number)
    }
}