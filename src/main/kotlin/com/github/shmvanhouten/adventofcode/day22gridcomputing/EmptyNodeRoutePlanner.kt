package com.github.shmvanhouten.adventofcode.day22gridcomputing

class EmptyNodeRoutePlanner {

    fun getRouteToCoordinate(targetCoordinate: Coordinate, sourceCoordinate: Coordinate, storageCluster: StorageCluster): NodeRoute {
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