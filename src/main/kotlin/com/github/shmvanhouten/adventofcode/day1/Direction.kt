package com.github.shmvanhouten.adventofcode.day1

enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    fun turnLeft(): Direction {
        return if(this == NORTH) {
            WEST
        }else {
            Direction.values()[this.ordinal - 1]
        }
    }

    fun turnRight(): Direction {
        return if(this == WEST) {
            NORTH
        }else {
            Direction.values()[this.ordinal + 1]
        }
    }
}