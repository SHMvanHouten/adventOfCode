package com.github.shmvanhouten.adventofcode.day22gridcomputing

class EmptyNodeMover(private val storageCluster: StorageCluster, private val emptyNodeRoutePlanner: EmptyNodeRoutePlanner = EmptyNodeRoutePlanner()) {

    fun moveEmptyClusterTo(targetCoordinate: Coordinate): Pair<StorageCluster, Int> {

        val coordinateOfEmptyCluster = storageCluster.getEmptyCluster()?.coordinate!!
        val route = emptyNodeRoutePlanner.getRouteToCoordinate(targetCoordinate, coordinateOfEmptyCluster, storageCluster)

        return Pair(moveEmptyClusterOverRoute(route, coordinateOfEmptyCluster), route.shortestPath.size)
    }

    private fun moveEmptyClusterOverRoute(route: NodeRoute, coordinateOfEmptyCluster: Coordinate): StorageCluster {
        val originalClusterGrid = storageCluster.grid.toMutableMap()
        var coordinateOfPreviousNode = coordinateOfEmptyCluster
        for (coordinate in route.shortestPath) {
            val nodeToDumpDataTo = originalClusterGrid.getValue(coordinateOfPreviousNode)
            val nodeToClearDataFrom = originalClusterGrid.getValue(coordinate)
            originalClusterGrid.put(coordinate, buildStorageNode(coordinate, nodeToClearDataFrom, nodeToDumpDataTo))
            originalClusterGrid.put(coordinateOfPreviousNode, buildStorageNode(coordinateOfPreviousNode, nodeToDumpDataTo, nodeToClearDataFrom))
            coordinateOfPreviousNode = coordinate
        }
        return StorageCluster(originalClusterGrid)
    }

    private fun buildStorageNode(coordinate: Coordinate, nodeToTransferTo: StorageNode, nodeToTransferFrom: StorageNode): StorageNode {
        val size = nodeToTransferTo.size
        val used = nodeToTransferFrom.used
        return StorageNode(coordinate, size, used, size - used)
    }

}