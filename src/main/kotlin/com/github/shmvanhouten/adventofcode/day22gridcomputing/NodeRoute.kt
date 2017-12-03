package com.github.shmvanhouten.adventofcode.day22gridcomputing

data class NodeRoute(val coordinate: Coordinate,
                     val shortestPath: Set<Coordinate> = emptySet()) {

    override fun equals(other: Any?): Boolean {
        return if(other is NodeRoute) {
            this.coordinate == other.coordinate
        }else{
            false
        }
    }

    override fun hashCode(): Int {
        return coordinate.hashCode()
    }
}