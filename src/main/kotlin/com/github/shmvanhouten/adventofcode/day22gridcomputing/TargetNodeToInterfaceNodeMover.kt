package com.github.shmvanhouten.adventofcode.day22gridcomputing

import com.github.shmvanhouten.adventofcode.day22gridcomputing.RelativePosition.*

class TargetNodeToInterfaceNodeMover(private val cluster: StorageCluster, private val emptyNodeMover: EmptyNodeMover = EmptyNodeMover(cluster)) {

    fun moveTargetNodeDataToInterfaceNode(targetNodeCoordinate: Coordinate): Int {
        val (storageCluster, stepsTaken) = emptyNodeMover.moveEmptyClusterTo(targetNodeCoordinate + LEFT.coordinate)
        return stepsTaken + (targetNodeCoordinate.x - 1) * 5 + 1
    }
}