package com.github.shmvanhouten.adventofcode.day17twostepsforward

data class Coordinate (val x: Int, val y: Int): Comparable<Coordinate>{
    override fun compareTo(other: Coordinate): Int {
        return if (this.y == other.y) this.x.compareTo(other.x)
        else this.y.compareTo(other.y)
    }

}

