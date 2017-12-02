package com.github.shmvanhouten.adventofcode.day22gridcomputing

class StorageCluster(val grid: Map<Coordinate, StorageNode>) {


//    fun getAdjacentNodes(coordinate: Coordinate): List<StorageNode> {
//        val x = coordinate.x
//        val y = coordinate.y
//        var adjacentStorageNodes = listOf<StorageNode>()
//
//        val leftCoordinate = Coordinate(x - 1, y)
//        if (this.containsNode(leftCoordinate)) {
//            adjacentStorageNodes += getNode(leftCoordinate)
//        }
//
//        val rightCoordinate = Coordinate(x + 1, y)
//        if (this.containsNode(rightCoordinate)) {
//            adjacentStorageNodes += getNode(rightCoordinate)
//        }
//
//        val aboveCoordinate = Coordinate(x, y - 1)
//        if (this.containsNode(aboveCoordinate)) {
//            adjacentStorageNodes += getNode(aboveCoordinate)
//        }
//
//        val belowCoordinate = Coordinate(x, y + 1)
//        if (this.containsNode(belowCoordinate)) {
//            adjacentStorageNodes += getNode(belowCoordinate)
//        }
//
//        return adjacentStorageNodes
//    }
}