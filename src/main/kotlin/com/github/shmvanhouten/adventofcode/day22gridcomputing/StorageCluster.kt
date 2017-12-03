package com.github.shmvanhouten.adventofcode.day22gridcomputing

class StorageCluster(val grid: Map<Coordinate, StorageNode>) {

    fun getEmptyCluster(): StorageNode?{
        return grid.values.find { it.used == 0 }
    }

    fun contains(coordinate: Coordinate): Boolean {
        return grid.containsKey(coordinate)
    }

    fun get(coordinate: Coordinate): StorageNode {
        return grid.getValue(coordinate)
    }
}