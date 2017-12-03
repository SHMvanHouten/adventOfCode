package com.github.shmvanhouten.adventofcode.day22gridcomputing

data class Coordinate(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        return if(other is Coordinate){
            this.x == other.x && this.y == other.y
        }else{
            false
        }
    }

    operator fun plus(otherCoordinate: Coordinate): Coordinate {
        val x = this.x + otherCoordinate.x
        val y = this.y + otherCoordinate.y
        return Coordinate(x, y)
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}