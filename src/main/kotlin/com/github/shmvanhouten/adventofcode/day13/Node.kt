package com.github.shmvanhouten.adventofcode.day13

data class Node(val coordinate: Coordinate,
                val shortestPath: List<Node> = emptyList(),
                var adjacentNodes: List<Node> = mutableListOf())