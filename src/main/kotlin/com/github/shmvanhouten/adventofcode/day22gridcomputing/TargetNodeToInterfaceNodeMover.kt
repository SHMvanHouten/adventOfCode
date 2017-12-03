package com.github.shmvanhouten.adventofcode.day22gridcomputing

class TargetNodeToInterfaceNodeMover(private val cluster: StorageCluster) {

    fun moveTargetNodeDataToInterfaceNode(targetNodeCoordinate: Coordinate): Int {
        return (targetNodeCoordinate.x - 1) * 5 + 1
    }
}