package com.github.shmvanhouten.adventofcode.day13

data class Node(val coordinate: Coordinate,
                val shortestPath: List<Node> = emptyList()){


    override fun equals(other: Any?): Boolean {
        val otherNode = other as Node
        return this.coordinate == otherNode.coordinate
    }

    override fun hashCode(): Int {
        return coordinate.hashCode()
    }
}