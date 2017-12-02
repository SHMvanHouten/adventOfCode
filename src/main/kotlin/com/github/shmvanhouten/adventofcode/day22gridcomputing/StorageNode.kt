package com.github.shmvanhouten.adventofcode.day22gridcomputing

data class StorageNode(val coordinate: Coordinate,
                       val size: Int,
                       val used: Int,
                       val available: Int)