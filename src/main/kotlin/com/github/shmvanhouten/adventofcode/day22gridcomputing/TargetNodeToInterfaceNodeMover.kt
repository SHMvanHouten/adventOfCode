package com.github.shmvanhouten.adventofcode.day22gridcomputing

import com.github.shmvanhouten.adventofcode.day22gridcomputing.RelativePosition.*

class TargetNodeToInterfaceNodeMover(private val cluster: StorageCluster, private val emptyNodeMover: EmptyNodeMover = EmptyNodeMover(cluster)) {

    private val INTERFACE_NODE_COORDINATE = Coordinate(0, 0)

    fun moveTargetNodeDataToInterfaceNode(targetNodeCoordinate: Coordinate): Pair<StorageCluster, Int> {
        val (storageCluster, stepsTakenToMoveEmptyCluster) = emptyNodeMover.moveEmptyClusterTo(targetNodeCoordinate + LEFT.coordinate)
        // assumptions: empty node is next to the target node, both top roads are 'clear' to move the target node data
        val (storageClusterWithTargetNodeInposition, stepsTakenToMoveTargetNode) = useEmptyClusterToMoveTargetNodeToInterfaceNode(storageCluster, targetNodeCoordinate)
        return Pair(storageClusterWithTargetNodeInposition, stepsTakenToMoveEmptyCluster + stepsTakenToMoveTargetNode)
    }

    private fun useEmptyClusterToMoveTargetNodeToInterfaceNode(storageCluster: StorageCluster, targetNodeCoordinate: Coordinate): Pair<StorageCluster, Int> {
        var storageGrid = storageCluster.grid
        var amountOfSteps = 0

        var coordinateTargetDataIsAt = targetNodeCoordinate
        val emptyNodeCoordinate = coordinateTargetDataIsAt.plus(LEFT.coordinate)


        storageGrid = moveDataToEmptyNode(storageGrid, coordinateTargetDataIsAt, emptyNodeCoordinate)
        coordinateTargetDataIsAt = emptyNodeCoordinate
        amountOfSteps++

        while (coordinateTargetDataIsAt != INTERFACE_NODE_COORDINATE) {
            storageGrid = moveEmptyNodeAroundTargetDataNode(storageGrid, coordinateTargetDataIsAt.plus(RIGHT.coordinate))
            amountOfSteps += 4

            val newEmptyNodeCoordinate = coordinateTargetDataIsAt.plus(LEFT.coordinate)
            storageGrid = moveDataToEmptyNode(storageGrid, coordinateTargetDataIsAt, newEmptyNodeCoordinate)
            coordinateTargetDataIsAt = newEmptyNodeCoordinate
            amountOfSteps++
        }
        return Pair(StorageCluster(storageGrid), amountOfSteps)
    }

    private fun moveEmptyNodeAroundTargetDataNode(storageGrid: Map<Coordinate, StorageNode>, rightOfTargetNode: Coordinate): Map<Coordinate, StorageNode> {
        var storageGridToMoveEmptyNodeAround = storageGrid

        val bottomRightOfTargetNode = rightOfTargetNode.plus(DOWN.coordinate)
        storageGridToMoveEmptyNodeAround = moveDataToEmptyNode(storageGridToMoveEmptyNodeAround, bottomRightOfTargetNode, rightOfTargetNode)

        val belowTargetNode = bottomRightOfTargetNode.plus(LEFT.coordinate)
        storageGridToMoveEmptyNodeAround = moveDataToEmptyNode(storageGridToMoveEmptyNodeAround, belowTargetNode, bottomRightOfTargetNode)

        val bottomLeftOfTargetNode = belowTargetNode.plus(LEFT.coordinate)
        storageGridToMoveEmptyNodeAround = moveDataToEmptyNode(storageGridToMoveEmptyNodeAround, bottomLeftOfTargetNode, belowTargetNode)

        val leftOfTargetNode = bottomLeftOfTargetNode.plus(UP.coordinate)
        storageGridToMoveEmptyNodeAround = moveDataToEmptyNode(storageGridToMoveEmptyNodeAround, leftOfTargetNode, bottomLeftOfTargetNode)

        return storageGridToMoveEmptyNodeAround
    }

    private fun moveDataToEmptyNode(storageGrid: Map<Coordinate, StorageNode>, coordinateDataIsAt: Coordinate, emptyNodeCoordinate: Coordinate): Map<Coordinate, StorageNode> {
        val storageGridTemp = storageGrid.toMutableMap()
        val emptyNode = storageGrid.getValue(emptyNodeCoordinate)
        val nodeWithTargetData = storageGrid.getValue(coordinateDataIsAt)
        storageGridTemp.put(emptyNodeCoordinate, buildStorageNode(emptyNodeCoordinate, emptyNode, nodeWithTargetData))
        storageGridTemp.put(coordinateDataIsAt, buildStorageNode(coordinateDataIsAt, nodeWithTargetData, emptyNode))
        return storageGridTemp
    }

    private fun buildStorageNode(coordinate: Coordinate, nodeToTransferTo: StorageNode, nodeToTransferFrom: StorageNode): StorageNode {
        val size = nodeToTransferTo.size
        val used = nodeToTransferFrom.used
        return StorageNode(coordinate, size, used, size - used)
    }
}