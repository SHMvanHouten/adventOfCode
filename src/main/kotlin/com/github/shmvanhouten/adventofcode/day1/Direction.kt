package com.github.shmvanhouten.adventofcode.day1

enum class Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    fun turnRight(): Direction {
        return if(this == NORTH) {
            WEST
        }else {
            Direction.values()[this.ordinal - 1]
        }
    }

    fun turnLeft(): Direction {
        return if(this == EAST) {
            NORTH
        }else {
            Direction.values()[this.ordinal + 1]
        }
    }
}