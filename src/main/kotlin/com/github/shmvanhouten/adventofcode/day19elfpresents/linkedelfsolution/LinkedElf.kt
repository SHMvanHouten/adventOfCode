package com.github.shmvanhouten.adventofcode.day19elfpresents.linkedelfsolution

data class LinkedElf(val number: Int) {
    var nextElf: LinkedElf = this
}