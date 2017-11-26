package com.github.shmvanhouten.adventofcode.day13

class PathFinder {
    private val SOURCE_COORDINATE = Coordinate(1, 1)

    fun getPathsToVisitedNodes(maze: Maze): Set<Node> {

        var visitedNodes = setOf<Node>()
        var unvisitedNodes = setOf(Node(SOURCE_COORDINATE))

        while (unvisitedNodes.isNotEmpty()) {
            val currentNode = getLowestDistanceNode(unvisitedNodes)
            unvisitedNodes -= currentNode

            buildAdjacentNodes(currentNode, maze)
                    .forEach { adjacentNode ->

                val possibleVisitedNode: Node? = visitedNodes.find { it == adjacentNode }
                if (possibleVisitedNode != null) {

                    if (possibleVisitedNode.shortestPath.size > adjacentNode.shortestPath.size) {
                        visitedNodes -= possibleVisitedNode
                        unvisitedNodes += adjacentNode
                    }

                } else {
                    unvisitedNodes += adjacentNode
                }
            }

            visitedNodes = addCurrentNodeToVisitedNodeIfItHasTheShortestPath(visitedNodes, currentNode)
        }


        return visitedNodes
    }

    private fun addCurrentNodeToVisitedNodeIfItHasTheShortestPath(originalVisitedNodes: Set<Node>, currentNode: Node): Set<Node> {
        var newVisitedNodes = originalVisitedNodes
        val possibleVisitedNode: Node? = newVisitedNodes.find { it == currentNode }
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

    private fun buildAdjacentNodes(originNode: Node, maze: Maze): List<Node> =
            maze.getAdjacentCorridors(originNode.coordinate)
                    .map { Node(it, shortestPath = originNode.shortestPath.plus(it)) }


    private fun getLowestDistanceNode(unvisitedNodes: Set<Node>): Node =
            unvisitedNodes.minBy { it.shortestPath.size } ?: unvisitedNodes.first()

}
