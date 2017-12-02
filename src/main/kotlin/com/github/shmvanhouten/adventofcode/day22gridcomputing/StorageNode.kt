package com.github.shmvanhouten.adventofcode.day22gridcomputing

data class StorageNode(val coordinate: Coordinate,
                       val size: Int,
                       val used: Int,
                       val available: Int) {
    override fun equals(other: Any?): Boolean {
        val otherNode = other as StorageNode
        return this.coordinate == otherNode.coordinate
    }

    override fun hashCode(): Int {
        return coordinate.hashCode()
    }
}