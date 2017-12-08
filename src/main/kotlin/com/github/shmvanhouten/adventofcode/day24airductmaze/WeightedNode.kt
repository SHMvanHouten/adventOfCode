package com.github.shmvanhouten.adventofcode.day24airductmaze

data class WeightedNode(val locationNumber: Int,
                        val locationsVisited: List<Int>,
                        val weight: Int = 0)
