package com.github.shmvanhouten.adventofcode.day22gridcomputing

class EmptyNodeMover(private val storageCluster: StorageCluster) {

    fun moveEmptyClusterTo(targetCoordinate: Coordinate): Pair<StorageCluster, Int> {

        val coordinateOfEmptyCluster = storageCluster.getEmptyCluster()?.coordinate!!
        val route = getRouteToCoordinate(targetCoordinate, coordinateOfEmptyCluster)

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

    private fun getRouteToCoordinate(targetCoordinate: Coordinate, sourceCoordinate: Coordinate): NodeRoute {
        //Todo: consolidate with week 13 routeFinder
        var visitedNodes = setOf<NodeRoute>()
        var unvisitedNodes = setOf(NodeRoute(sourceCoordinate))

        while (unvisitedNodes.isNotEmpty()) {
            val currentNode = getLowestDistanceNode(unvisitedNodes)
            unvisitedNodes -= currentNode
            val adjacentNodes = buildAdjacentNodes(currentNode, storageCluster)

            adjacentNodes.forEach { adjacentNode ->
                val possibleVisitedNode = visitedNodes.find { it == adjacentNode }
                if (possibleVisitedNode != null) {

                    if (possibleVisitedNode.shortestPath.size > adjacentNode.shortestPath.size) {
                        visitedNodes -= possibleVisitedNode
                        unvisitedNodes += adjacentNode
                    }
                } else {
                    unvisitedNodes += adjacentNode
                }
                visitedNodes = addCurrentNodeToVisitedNodeIfItHasTheShortestPath(visitedNodes, currentNode)
            }

        }
        return visitedNodes.find { it.coordinate == targetCoordinate }!!
    }

    private fun addCurrentNodeToVisitedNodeIfItHasTheShortestPath(originalVisitedNodes: Set<NodeRoute>, currentNode: NodeRoute): Set<NodeRoute> {
        var newVisitedNodes = originalVisitedNodes
        val possibleVisitedNode: NodeRoute? = newVisitedNodes.find { it == currentNode }
        if (possibleVisitedNode != null) {

            if (possibleVisitedNode.shortestPath.size > currentNode.shortestPath.size) {
                newVisitedNodes -= possibleVisitedNode
                newVisitedNodes += currentNode
            } // else keep the original visited node with the shorter path

        } else {
            newVisitedNodes += currentNode
        }
        return newVisitedNodes
    }

    private fun buildAdjacentNodes(currentNode: NodeRoute, storageCluster: StorageCluster): List<NodeRoute> {
        val currentCoordinate = currentNode.coordinate
        return RelativePosition.values().map { it.coordinate + currentCoordinate }
                .filter { storageCluster.contains(it) }
                .filter { storageCluster.get(it).used <= storageCluster.get(currentCoordinate).size }
                .map { NodeRoute(it, currentNode.shortestPath.plus(it)) }
    }

    private fun getLowestDistanceNode(unvisitedNodes: Set<NodeRoute>): NodeRoute {
        return unvisitedNodes.minBy { it.shortestPath.size } ?: unvisitedNodes.first()
    }


}